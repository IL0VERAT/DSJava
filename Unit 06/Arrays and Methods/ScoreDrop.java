import java.util.Scanner;
public class ScoreDrop {
    static double least = Double.POSITIVE_INFINITY ;
    static int currentSize = 0;

    public static void dropper(double[] testArrays) {
        double searchedValue = least;
        int pos = 0;
        boolean found = false;


        while (pos < testArrays.length && !found) {
            if (testArrays[pos] == searchedValue) {
                testArrays[pos] = testArrays[currentSize - 1];
                currentSize--;
                found = true;
            } else {
                pos++;
            }
        }

        for (int i = 0; i < currentSize; i++) {
            System.out.println(testArrays[i]);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[] testValues = new double[25];
        while (true) {
            for (int i = 0; i < testValues.length; i++) {

                // asks the user for test scores
                System.out.print("Enter a test score (enter q to quit or y to drop the lowest test score): ");

                // stops program if user inputs q or Q
                if (in.hasNext("q") || in.hasNext("Q")) {
                    in.next();
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
        System.out.println("Would you like to drop your lowester score? Enter Y for yes or N for no: ");
        String yesNo = in.next();
        if (yesNo.equals("y") || yesNo.equals("Y")) {
            ScoreDrop.dropper(testValues);
        } else {
            System.out.print("");
        }

    }
}
