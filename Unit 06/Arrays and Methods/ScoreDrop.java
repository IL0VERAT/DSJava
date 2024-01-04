//Coder: Milo Linn-Boggs Date: 01/04/24
import java.util.Scanner;
public class ScoreDrop {
    static double least = Double.POSITIVE_INFINITY ;
    
    //method to drop the lowest test score
    public static void dropper(double[] testArrays, int currentSize) {
        double searchedValue = least;
        int pos = 0;
        boolean found = false;

        //linear search to find lowest score and remove it
        while (pos < testArrays.length && !found) {
            if (testArrays[pos] == searchedValue) {
                for(int i = pos + 1; i < currentSize; i++){
                    testArrays[i - 1] = testArrays[i];
                }
                currentSize--;
                found = true;
            } else {
                pos++;
            }
        }

        //prints out test scores. 
        System.out.println("TEST SCORES: ");
        for (int i = 0; i < currentSize; i++) {
            System.out.println(testArrays[i]);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int currentSize = 0;
        double[] testValues = new double[25];
        while (true) {
            for (int i = 0; i < testValues.length; i++) {

                // asks the user for test scores
                System.out.print("Enter a test score (enter q to quit or y to drop the lowest test score): ");

                // stops program if user inputs q or Q
                if (in.hasNext("q") || in.hasNext("Q")) {
                    in.next();
                    System.out.println("TEST SCORES: ");
                    for (int j = 0; j < currentSize; j++) {
                        System.out.println(testValues[j]);
                    }
                    break;
                }

                // assigns the user input to the corresponding place in the array
                testValues[i] = in.nextDouble();
                currentSize++;

                // checks to see what the smallest test score is
                if (testValues[i] < least) {
                    least = testValues[i];
                }
            }
            break;
        }
        //code to ask user if they would like to drop the lowest score
        System.out.println("Would you like to drop your lowester score? Enter Y for yes or N for no: ");
        String yesNo = in.next();
        if (yesNo.equals("y") || yesNo.equals("Y")) {
            ScoreDrop.dropper(testValues, currentSize);
        } else {
            System.out.print("");
        }

    }
}
