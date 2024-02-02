//Coder: Milo Linn-Boggs Date: 1 Feb. 2024
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Sales {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("sales_by_cat.txt"); // imports the .txt file
        Scanner in = new Scanner(inputFile);
        // process file line by line
        // loop where there is still a next line in the file.
        while (in.hasNextLine()) {
            double cost;
            String line = in.nextLine();

            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter("[,\\n\\s]+");

            String name = lineScanner.next().trim();
            String nextWord = lineScanner.next().trim();
            nextWord = nextWord.replaceAll(",", "");
            nextWord = nextWord.trim();
            if(lineScanner.hasNextDouble()){
            String amount = lineScanner.next().trim();
                cost = Double.valueOf(amount);
            } else {
                cost = 0;
            }
            // prints formatted output
            System.out.printf("%-16s | %-10s | $%10.2f%n", name, nextWord, cost );
        }
    }
}
