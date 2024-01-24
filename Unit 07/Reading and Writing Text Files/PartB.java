//Coder: Milo Linn-Boggs Date: 23 Jan. 2023
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
        int counter = -1;
        double total = 0;
        double scores = 0;

        //reads in values from txt file and inputs into other txt file
        while (in.hasNext()) {
            counter++;
            scores = in.nextDouble();
            out.printf("Quiz %03d:%7.2f%n", counter, scores);
            total += scores;
        }
        //prints out the average of the test scores
        out.println("----------------");
        out.printf("AVERAGE: %7.2f%n", (total / counter));
        in.close();
        out.close();
    }
}
