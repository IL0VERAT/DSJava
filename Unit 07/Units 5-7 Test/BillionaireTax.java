//Coder: Milo Linn-Boggs Date: 07 Feb. 2024
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class BillionaireTax{
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File ("Billionaires.txt");
        Scanner in  = new Scanner (inputFile);

        //scans in test from .txt file and prints it out
        while(in.hasNextLine()){
            String line = in.nextLine();
            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter("[;\\n]+");

            String names = lineScanner.next().trim();
            String nextWord = lineScanner.next().trim();
            nextWord = nextWord.replaceAll(",", "");
            nextWord = nextWord.replaceAll("\\$", "");
            double netWorth = Double.valueOf(nextWord);
            double taxes = netWorth * 0.03;
            String region = lineScanner.next().trim();

            //prints out result in formatted manner
            System.out.printf("%-16s : $ %-14.2f | $ %-13.2f | %-20s%n", names, netWorth, taxes, region);
        }
    }
}