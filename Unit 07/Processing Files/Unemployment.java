
//Coder: Milo Linn-Boggs Date: 1 Feb. 2024
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Unemployment {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("Unemployment.txt"); // imports the .txt file
        Scanner in = new Scanner(inputFile);

        // creates the top title
        System.out.println("--------------------------------------------------------------");
        System.out.println("                   Top 5 Unemployment Rates                ");
        System.out.println("--------------------------------------------------------------");
        // process file line by line
        // loop where there is still a next line in the file.
        while (in.hasNextLine()) {
            String line = in.nextLine();

            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter("[,\\n]+");

            String name = lineScanner.next().trim();
            String nextWord = lineScanner.next().trim();
            nextWord = nextWord.replaceAll(",", "");
            double unempolyment = Double.valueOf(nextWord);
            nextWord = lineScanner.next().trim();

            int rank = Integer.valueOf(nextWord);
            String region = lineScanner.next().trim();

            // prints formatted output
            System.out.printf("Ranked #%3d: %-16s | %,-5.2f%% | %-20s%n", rank, name, unempolyment, region);
        }
        System.out.println("--------------------------------------------------------------");
    }
}