//Coder: Milo Linn-Boggs Date: 24 Feb. 2024
import java.util.Scanner;
import mower.Yard;
import mower.Mower;
import mower.Mower.DIRECTION;

public class YardShowcase {
    public static void main(String[] args) {

        //asks the user for yard dimensions
        Scanner in  = new Scanner(System.in);
        System.out.println("Enter the dimensions for a new yard: ");
        int x = in.nextInt();
        int y = in.nextInt();

        //prints out the new yard
        Yard yard = new Yard(x, y);
        Mower mower = new Mower(2, 1, DIRECTION.RIGHT);
        yard.printYard(mower);
    }
}
