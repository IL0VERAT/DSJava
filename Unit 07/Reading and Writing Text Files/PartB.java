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
        double counter = 0;
        double total = 0;
        double scores = 0;

        while (in.hasNext()) {
            counter++;
            scores = in.nextDouble();
            out.printf("Quiz %03f:%7.2f%n", counter, scores);
            total += scores;
        }
        //prints out the average of the test scores
        out.println("----------------");
        out.printf("AVERAGE: %7.2f%n", (total / counter));
        in.close();
        out.close();
    }
}
