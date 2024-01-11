//Coder: Milo Linn-Boggs Date: 11 Jan. 2024
import java.util.ArrayList;
import java.util.Scanner;
public class CalcTestScore {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Double> testScores = new ArrayList<Double>();
        double counter = 0;
        //asks user to input tests scores 
        while (true) {
            System.out.println("Enter a test score: ");

            //if Q or q is inputted, program stops
            if (in.hasNext("q")||in.hasNext("Q")) {
                in.next();
                break;
            } else {
                testScores.add(in.nextDouble());
            }
        }

        //prints out formatted test scores
        System.out.println("TEST SCORES: ");
        for(int i = 0; i < testScores.size(); i++){
            counter += testScores.get(i);
            System.out.printf("%.2f%n",testScores.get(i));
        }

        //prints out the average of the test scores
        System.out.printf("Average of test scores: %.2f",counter/testScores.size());

        
    }
}
