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
