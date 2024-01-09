import java.util.ArrayList;
import java.util.Scanner;
public class CalcTestScore {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Double> testScores = new ArrayList<Double>();
        double counter = 0;
        while (true) {
            System.out.println("Enter a test score: ");

            if (in.hasNext("q")||in.hasNext("Q")) {
                in.next();
                break;
            } else {
                testScores.add(in.nextDouble());
            }
        }

        System.out.println("TEST SCORES: ");
        for(int i = 0; i < testScores.size(); i++){
            counter += testScores.get(i);
            System.out.printf("%.2f%n",testScores.get(i));
        }

        System.out.printf("Average of test scores: %.2f",counter/testScores.size());

        
    }
}
