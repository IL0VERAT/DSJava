import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PartB {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("quizzes.txt");
        Scanner in = new Scanner(inputFile);

        File outputFile = new File("quizzesMod.txt");
        PrintWriter out = new PrintWriter(outputFile);

        while (in.hasNext()) {
            double score = in.nextDouble();
            out.printf("%6.2f%n", score);
        }
        in.close();
        out.close();
    }
}
