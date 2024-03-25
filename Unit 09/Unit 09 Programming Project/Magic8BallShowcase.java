import java.util.Scanner;
import org.derryfield.toys.Magic8Ball;

public class Magic8BallShowcase {
    public static void main(String[] args) {
        Magic8Ball magic8Ball = new Magic8Ball();
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.print("Ask a yes or no question or type q to quit: ");
            
            if (in.hasNext("q") || in.hasNext("Q")) {
                break;
            } else {
                Magic8Ball.shake();
            }
        } 
    }
}
