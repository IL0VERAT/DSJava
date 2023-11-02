//Coder: Milo Linn-Boggs Date: 1 Nov. 2023. 
import java.util.Scanner;
public class TestAverages {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        //Tells user essential info to run program
        System.out.println("Essential User Information: Enter double values and put in negative number to end program.");
        
        //creates tally (number of times program runs) and sets to 0
        int tally = 0;
        //creates test_Score (variable for the users input)
        double test_Score;
        //creates loopFlag to test whether user inputs a negative value and stops if it is so
        boolean loopFlag = true;
        //the variable that represents the changing total amount
        double total_Value = 0;
        //the variable that will represent the calculated average of the test scores
        double average;

        //while condition is true, asks user to input test score and run other functions
        do {
            System.out.print("Enter a test score: ");
            test_Score = in.nextDouble();
            
            //checks to see if a negative value is inputted
            if (test_Score >= 0){
                //if positive value, runs calculations
                tally++;
                total_Value = total_Value + test_Score;
            } else {
                //if negative value, stops loop
                loopFlag = false;
            }
            //sets the condition
        } while(loopFlag == true);

        //calculates the average
        average = total_Value/tally;

        //prints out the results
        System.out.printf("The number of entries is %d test score average is %.02f. ",tally,average);

    }
}
