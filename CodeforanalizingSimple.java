//Teagan Peabody and Milo Lin-Boggs code for analyzing form responses from a CSV file using K-Medoids clustering with Gower distance.

import java.io.*;
import java.util.*;

public class CodeforanalizingSimple {

    static class DataPoint {
        String[] values;
        int clusterId = -1;

        DataPoint(String[] values) {
            this.values = values;
        }
    }

    static class Cluster {
        List<DataPoint> points = new ArrayList<>();
        String[] centroid;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter CSV file path: ");
        String filePath = scanner.nextLine();

        try {
            // Read CSV data
            List<DataPoint> data = new ArrayList<>();
            String[] headers = null;
            boolean[] isNumeric = null;

            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line = br.readLine();
            if (line != null) {
                headers = parseCsvLine(line);
                isNumeric = new boolean[headers.length];
            }

            // Read all data points
            while ((line = br.readLine()) != null) {
                String[] values = parseCsvLine(line);
                if (values.length > 0) {
                    data.add(new DataPoint(values));
                }
            }
            br.close();

            if (data.isEmpty()) {
                System.out.println("No data found in CSV file.");
                return;
            }

            // Determine which columns are numeric
            detectNumericColumns(data, isNumeric);

            // Normalize numeric columns
            normalizeData(data, isNumeric);

            // Determine optimal number of clusters using silhouette score
            int optimalK = findOptimalClusters(data, isNumeric);
            System.out.println("Optimal number of clusters: " + optimalK);

            // Perform K-Medoids clustering
            List<Cluster> clusters = kMedoidsClustering(data, optimalK, isNumeric);

            // Output results
            System.out.println("\n=== CLUSTERING RESULTS ===\n");
            for (int i = 0; i < clusters.size(); i++) {
                System.out.println("Cluster " + (i + 1) + " (" + clusters.get(i).points.size() + " observations):");
                for (DataPoint dp : clusters.get(i).points) {
                    System.out.println("  " + Arrays.toString(dp.values));
                }
                System.out.println();
            }

            // Save results to file
            saveResults(clusters, headers, filePath);

            // Generate scatter plot visualization
            generateScatterPlot(clusters, headers, filePath, isNumeric);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        scanner.close();
    }

    static String[] parseCsvLine(String line) {
        List<String> values = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean inQuotes = false;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (c == ',' && !inQuotes) {
                values.add(current.toString().trim());
                current = new StringBuilder();
            } else {
                current.append(c);
            }
        }
        values.add(current.toString().trim());

        return values.toArray(new String[0]);
    }

    static void detectNumericColumns(List<DataPoint> data, boolean[] isNumeric) {
        Arrays.fill(isNumeric, true);

        for (DataPoint dp : data) {
            for (int i = 0; i < dp.values.length && i < isNumeric.length; i++) {
                if (isNumeric[i] && !isNumericValue(dp.values[i])) {
                    isNumeric[i] = false;
                }
            }
        }
    }

    static boolean isNumericValue(String value) {
        if (value == null || value.isEmpty())
            return false;
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static void normalizeData(List<DataPoint> data, boolean[] isNumeric) {
        int numCols = data.get(0).values.length;

        for (int col = 0; col < numCols; col++) {
            if (isNumeric[col]) {
                double min = Double.MAX_VALUE;
                double max = Double.MIN_VALUE;

                for (DataPoint dp : data) {
                    try {
                        double val = Double.parseDouble(dp.values[col]);
                        min = Math.min(min, val);
                        max = Math.max(max, val);
                    } catch (NumberFormatException e) {
                    }
                }

                if (max - min > 0) {
                    for (DataPoint dp : data) {
                        try {
                            double val = Double.parseDouble(dp.values[col]);
                            dp.values[col] = String.valueOf((val - min) / (max - min));
                        } catch (NumberFormatException e) {
                        }
                    }
                }
            }
        }
    }

    static double gowerDistance(DataPoint p1, DataPoint p2, boolean[] isNumeric) {
        double sum = 0;
        int validCount = 0;

        for (int i = 0; i < Math.min(p1.values.length, p2.values.length); i++) {
            if (isNumeric[i]) {
                try {
                    double v1 = Double.parseDouble(p1.values[i]);
                    double v2 = Double.parseDouble(p2.values[i]);
                    sum += Math.abs(v1 - v2);
                    validCount++;
                } catch (NumberFormatException e) {
                }
            } else {
                // Text similarity using Jaccard coefficient on words
                sum += 1 - textSimilarity(p1.values[i], p2.values[i]);
                validCount++;
            }
        }

        return validCount > 0 ? sum / validCount : 1.0;
    }

    static double textSimilarity(String s1, String s2) {
        if (s1.equalsIgnoreCase(s2))
            return 1.0;

        Set<String> words1 = new HashSet<>(Arrays.asList(s1.toLowerCase().split("\\s+")));
        Set<String> words2 = new HashSet<>(Arrays.asList(s2.toLowerCase().split("\\s+")));

        Set<String> intersection = new HashSet<>(words1);
        intersection.retainAll(words2);

        Set<String> union = new HashSet<>(words1);
        union.addAll(words2);

        return union.isEmpty() ? 0.0 : (double) intersection.size() / union.size();
    }

    static int findOptimalClusters(List<DataPoint> data, boolean[] isNumeric) {
        int maxK = Math.min(10, data.size() / 2);
        double bestScore = -1;
        int optimalK = 2;

        for (int k = 2; k <= maxK; k++) {
            List<Cluster> clusters = kMedoidsClustering(data, k, isNumeric);
            double score = silhouetteScore(clusters, isNumeric);

            if (score > bestScore) {
                bestScore = score;
                optimalK = k;
            }
        }

        return optimalK;
    }

    static double silhouetteScore(List<Cluster> clusters, boolean[] isNumeric) {
        double totalScore = 0;
        int count = 0;

        for (Cluster cluster : clusters) {
            for (DataPoint point : cluster.points) {
                double a = averageDistanceInCluster(point, cluster, isNumeric);
                double b = minAverageDistanceToOtherClusters(point, cluster, clusters, isNumeric);

                if (Math.max(a, b) > 0) {
                    totalScore += (b - a) / Math.max(a, b);
                    count++;
                }
            }
        }

        return count > 0 ? totalScore / count : 0;
    }

    static double averageDistanceInCluster(DataPoint point, Cluster cluster, boolean[] isNumeric) {
        if (cluster.points.size() <= 1)
            return 0;

        double sum = 0;
        for (DataPoint other : cluster.points) {
            if (other != point) {
                sum += gowerDistance(point, other, isNumeric);
            }
        }
        return sum / (cluster.points.size() - 1);
    }

    static double minAverageDistanceToOtherClusters(DataPoint point, Cluster currentCluster,
            List<Cluster> allClusters, boolean[] isNumeric) {
        double minAvg = Double.MAX_VALUE;

        for (Cluster cluster : allClusters) {
            if (cluster != currentCluster && !cluster.points.isEmpty()) {
                double sum = 0;
                for (DataPoint other : cluster.points) {
                    sum += gowerDistance(point, other, isNumeric);
                }
                minAvg = Math.min(minAvg, sum / cluster.points.size());
            }
        }

        return minAvg;
    }

    static List<Cluster> kMedoidsClustering(List<DataPoint> data, int k, boolean[] isNumeric) {
        List<DataPoint> medoids = new ArrayList<>();

        // Initialize medoids randomly with fixed seed for reproducibility
        List<DataPoint> shuffled = new ArrayList<>(data);
        Collections.shuffle(shuffled, new Random(42));
        for (int i = 0; i < k; i++) {
            medoids.add(shuffled.get(i));
        }

        boolean changed = true;
        int maxIterations = 100;
        int iteration = 0;

        while (changed && iteration < maxIterations) {
            changed = false;
            iteration++;

            // Create clusters
            List<Cluster> clusters = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                clusters.add(new Cluster());
            }

            // Assign points to nearest medoid
            for (DataPoint dp : data) {
                int nearest = 0;
                double minDist = Double.MAX_VALUE;

                for (int i = 0; i < medoids.size(); i++) {
                    double dist = gowerDistance(dp, medoids.get(i), isNumeric);
                    if (dist < minDist) {
                        minDist = dist;
                        nearest = i;
                    }
                }

                clusters.get(nearest).points.add(dp);
                dp.clusterId = nearest;
            }

            // Update medoids
            for (int i = 0; i < k; i++) {
                if (!clusters.get(i).points.isEmpty()) {
                    DataPoint newMedoid = findMedoid(clusters.get(i), isNumeric);
                    if (newMedoid != medoids.get(i)) {
                        medoids.set(i, newMedoid);
                        changed = true;
                    }
                }
            }
        }

        // Final cluster assignment
        List<Cluster> finalClusters = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            finalClusters.add(new Cluster());
        }

        for (DataPoint dp : data) {
            int nearest = 0;
            double minDist = Double.MAX_VALUE;

            for (int i = 0; i < medoids.size(); i++) {
                double dist = gowerDistance(dp, medoids.get(i), isNumeric);
                if (dist < minDist) {
                    minDist = dist;
                    nearest = i;
                }
            }

            finalClusters.get(nearest).points.add(dp);
            dp.clusterId = nearest;
        }

        return finalClusters;
    }

    static DataPoint findMedoid(Cluster cluster, boolean[] isNumeric) {
        DataPoint bestMedoid = cluster.points.get(0);
        double minTotalDist = Double.MAX_VALUE;

        for (DataPoint candidate : cluster.points) {
            double totalDist = 0;
            for (DataPoint other : cluster.points) {
                totalDist += gowerDistance(candidate, other, isNumeric);
            }

            if (totalDist < minTotalDist) {
                minTotalDist = totalDist;
                bestMedoid = candidate;
            }
        }

        return bestMedoid;
    }

    static void saveResults(List<Cluster> clusters, String[] headers, String originalPath) {
        try {
            String outputPath = originalPath.replace(".csv", "_clustered.csv");
            PrintWriter writer = new PrintWriter(new FileWriter(outputPath));

            // Write header with cluster column
            writer.print("Cluster");
            for (String header : headers) {
                writer.print("," + header);
            }
            writer.println();

            // Write data with cluster assignments
            for (int i = 0; i < clusters.size(); i++) {
                for (DataPoint dp : clusters.get(i).points) {
                    writer.print(i + 1);
                    for (String value : dp.values) {
                        writer.print(",\"" + value + "\"");
                    }
                    writer.println();
                }
            }

            writer.close();
            System.out.println("Results saved to: " + outputPath);
        } catch (IOException e) {
            System.out.println("Error saving results: " + e.getMessage());
        }
    }

    static void generateScatterPlot(List<Cluster> clusters, String[] headers, String originalPath,
            boolean[] isNumeric) {
        try {
            String htmlPath = originalPath.replace(".csv", "_scatter_plot.html");
            PrintWriter writer = new PrintWriter(new FileWriter(htmlPath));

            writer.println("<!DOCTYPE html>");
            writer.println("<html><head><meta charset='UTF-8'>");
            writer.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            writer.println("<title>Cluster Scatter Plot</title>");
            writer.println("<script src='https://cdn.jsdelivr.net/npm/chart.js'></script>");
            writer.println("<style>");

            writer.println("* { margin: 0; padding: 0; box-sizing: border-box; }");
            writer.println(
                    "body { font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, sans-serif; background: #f5f7fa; padding: 2rem; }");
            writer.println(".container { max-width: 1200px; margin: 0 auto; }");
            writer.println("h1 { color: #2c3e50; margin-bottom: 2rem; text-align: center; }");
            writer.println(
                    ".card { background: white; border-radius: 12px; padding: 2rem; box-shadow: 0 4px 6px rgba(0,0,0,0.07); }");
            writer.println(
                    ".controls { margin-bottom: 2rem; display: flex; gap: 2rem; justify-content: center; align-items: center; }");
            writer.println("label { font-weight: 600; color: #2c3e50; }");
            writer.println(
                    "select { padding: 0.5rem 1rem; border: 2px solid #ecf0f1; border-radius: 8px; font-size: 1rem; cursor: pointer; }");
            writer.println("select:focus { outline: none; border-color: #3498db; }");

            writer.println("</style></head><body>");

            writer.println("<div class='container'>");
            writer.println("<h1>📊 Cluster Scatter Plot Visualization</h1>");

            writer.println("<div class='card'>");
            writer.println("<div class='controls'>");
            writer.println("<label>X-Axis: <select id='xAxis' onchange='updateScatterPlot()'>");
            for (int i = 0; i < headers.length; i++) {
                writer.println("<option value='" + i + "'>" + escapeHtml(headers[i]) + "</option>");
            }
            writer.println("</select></label>");
            writer.println("<label>Y-Axis: <select id='yAxis' onchange='updateScatterPlot()'>");
            for (int i = 0; i < headers.length; i++) {
                writer.println("<option value='" + i + "'" + (i == Math.min(1, headers.length - 1) ? " selected" : "")
                        + ">" + escapeHtml(headers[i]) + "</option>");
            }
            writer.println("</select></label>");
            writer.println("</div>");
            writer.println("<canvas id='scatterPlot'></canvas>");
            writer.println("</div>");

            writer.println("</div>");

            // JavaScript
            writer.println("<script>");

            String[] colors = { "#3498db", "#e74c3c", "#2ecc71", "#f39c12", "#9b59b6", "#1abc9c", "#e67e22", "#34495e",
                    "#16a085", "#c0392b" };

            writer.println("const allData = [");
            for (int i = 0; i < clusters.size(); i++) {
                Cluster cluster = clusters.get(i);
                for (DataPoint dp : cluster.points) {
                    writer.print("{cluster: " + (i + 1) + ", values: [");
                    for (int j = 0; j < dp.values.length; j++) {
                        String val = dp.values[j];
                        if (isNumeric[j]) {
                            try {
                                Double.parseDouble(val);
                                writer.print(val);
                            } catch (NumberFormatException e) {
                                writer.print("0");
                            }
                        } else {
                            writer.print(Math.abs(val.hashCode()) % 100);
                        }
                        if (j < dp.values.length - 1)
                            writer.print(", ");
                    }
                    writer.print("]},");
                }
            }
            writer.println("];");

            writer.println("const headers = [");
            for (int i = 0; i < headers.length; i++) {
                writer.print("'" + escapeHtml(headers[i]).replace("'", "\\'") + "'");
                if (i < headers.length - 1)
                    writer.print(", ");
            }
            writer.println("];");

            writer.println("const isNumeric = [");
            for (int i = 0; i < isNumeric.length; i++) {
                writer.print(isNumeric[i]);
                if (i < isNumeric.length - 1)
                    writer.print(", ");
            }
            writer.println("];");

            writer.println("const clusterColors = [");
            for (int i = 0; i < clusters.size(); i++) {
                writer.print("'" + colors[i % colors.length] + "'");
                if (i < clusters.size() - 1)
                    writer.print(", ");
            }
            writer.println("];");

            writer.println("let scatterChart;");
            writer.println("function updateScatterPlot() {");
            writer.println("  const xIdx = parseInt(document.getElementById('xAxis').value);");
            writer.println("  const yIdx = parseInt(document.getElementById('yAxis').value);");
            writer.println("  const datasets = [];");
            writer.println("  for (let c = 1; c <= " + clusters.size() + "; c++) {");
            writer.println("    const points = allData.filter(d => d.cluster === c).map(d => ({");
            writer.println("      x: d.values[xIdx],");
            writer.println("      y: d.values[yIdx]");
            writer.println("    }));");
            writer.println("    datasets.push({");
            writer.println("      label: 'Cluster ' + c,");
            writer.println("      data: points,");
            writer.println("      backgroundColor: clusterColors[c-1],");
            writer.println("      borderColor: clusterColors[c-1],");
            writer.println("      pointRadius: 7,");
            writer.println("      pointHoverRadius: 10");
            writer.println("    });");
            writer.println("  }");
            writer.println("  if (scatterChart) scatterChart.destroy();");
            writer.println("  scatterChart = new Chart(document.getElementById('scatterPlot'), {");
            writer.println("    type: 'scatter',");
            writer.println("    data: { datasets: datasets },");
            writer.println("    options: {");
            writer.println("      responsive: true,");
            writer.println("      maintainAspectRatio: true,");
            writer.println("      plugins: {");
            writer.println(
                    "        legend: { position: 'top', labels: { font: { size: 14 }, padding: 15 } },");
            writer.println("        tooltip: {");
            writer.println("          callbacks: {");
            writer.println("            label: function(context) {");
            writer.println("              let label = context.dataset.label || '';");
            writer.println("              if (label) label += ': ';");
            writer.println(
                    "              label += '(' + context.parsed.x.toFixed(2) + ', ' + context.parsed.y.toFixed(2) + ')';");
            writer.println("              return label;");
            writer.println("            }");
            writer.println("          }");
            writer.println("        }");
            writer.println("      },");
            writer.println("      scales: {");
            writer.println("        x: {");
            writer.println(
                    "          title: { display: true, text: headers[xIdx] + (isNumeric[xIdx] ? '' : ' (text hashed)'), font: { size: 14, weight: 'bold' } },");
            writer.println("          beginAtZero: true");
            writer.println("        },");
            writer.println("        y: {");
            writer.println(
                    "          title: { display: true, text: headers[yIdx] + (isNumeric[yIdx] ? '' : ' (text hashed)'), font: { size: 14, weight: 'bold' } },");
            writer.println("          beginAtZero: true");
            writer.println("        }");
            writer.println("      }");
            writer.println("    }");
            writer.println("  });");
            writer.println("}");
            writer.println("updateScatterPlot();");

            writer.println("</script>");
            writer.println("</body></html>");
            writer.close();

            System.out.println("Scatter plot visualization saved to: " + htmlPath);
            System.out.println("Open this file in your web browser to view the cluster plot.");

        } catch (IOException e) {
            System.out.println("Error generating scatter plot: " + e.getMessage());
        }
    }

    static String escapeHtml(String text) {
        return text.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }
}
