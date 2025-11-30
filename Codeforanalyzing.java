//Teagan Peabody and Milo Lin-Boggs code for analyzing form responses from a CSV file using K-Medoids clustering with Gower distance.

import java.io.*;
import java.util.*;

public class Codeforanalyzing {

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
                headers = line.split(",");
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
        Random rand = new Random();
        List<DataPoint> medoids = new ArrayList<>();

        // Initialize medoids randomly
        List<DataPoint> shuffled = new ArrayList<>(data);
        Collections.shuffle(shuffled);
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
}