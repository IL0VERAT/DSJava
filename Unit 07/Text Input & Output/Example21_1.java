import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Example21_1 {
    public static void main(String[] args) throws FileNotFoundException {
    File inputFile = new File("Top5Obesity.txt"); //can use full name here
    Scanner in = new Scanner(inputFile);
    //process file line by line
    //loop where there is still a nexy line in the file. 
    while (in.hasNextLine()) {
        String line = in.nextLine();
        Scanner lineScanner = new Scanner(line);
        lineScanner.useDelimiter("[,\\n]");
        String name  = lineScanner.next().trim();
        String nextWord = lineScanner.next().trim(); //need to trim, as could mess up code later
        double percentage = Double.valueOf(nextWord);
        nextWord = lineScanner.next().trim();
        int rank  = Integer.valueOf(nextWord);
        String region = lineScanner.next().trim();

        System.out.printf("Ranked #%3d: %16s, %6.2f%%, %20s%n",rank, name, percentage, region);
    }
}
}