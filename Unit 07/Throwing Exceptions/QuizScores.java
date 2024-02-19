import java.util.Scanner;

public class QuizScores {
    public static int getGrade(Scanner in) {
        System.out.print("Enter a test score: ");
        int score = in.nextInt();
        if(score >= 0 && score <=100){
            return score;
        } else {
            throw new ArithmeticException("Invalid Input!");
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            int test = getGrade(in);
            System.out.println("You got a quiz score of " + test);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}

/*
 * Part B: 
    public static int getInt() {
        try {
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
    }

    public static void main(String[] args) {
        System.out.println(getInt());
    }
    
    This will return 3, as finally means that something will always happen, no matter what happens in the try or catch statement
 */
