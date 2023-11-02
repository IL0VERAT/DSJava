import java.util.Scanner;
public class TestAverages {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        System.out.println("Essential User Information: Enter double values and put in negative number to end program.");
        
        int tally = 0;
        double test_Score;
        boolean loopFlag = true;
        double total_Value = 0;
        double average;

        do {
            System.out.print("Enter a test score: ");
            test_Score = in.nextDouble();
            
            if (test_Score >= 0){
                tally++;
                total_Value = total_Value + test_Score;
            } else {
                loopFlag = false;
            }
        } while(loopFlag == true);

        average = total_Value/tally;

        System.out.printf("The number of entries is %s test score average is %s. ",tally,average);

    }
}
