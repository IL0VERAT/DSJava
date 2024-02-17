import java.util.Scanner;

public class QuizScores {
    public static int getGrade(Scanner in) {
        try {
            int score = Integer.valueOf(in.nextInt());
            return score;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a test score: ");
        getGrade(in);

        
    }
}
