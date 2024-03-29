//Coder: Milo Linn-Boggs Date: 24 Feb. 2024
import java.util.Scanner;
import mower.Yard;
import mower.Mower;
import mower.Mower.DIRECTION;

public class YardShowcase {
    

    //clears the screen
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    //delays the lawn mower
    public static void delay(long mseconds) {
        try {
            Thread.sleep(mseconds);
        } catch (InterruptedException e) {
            System.err.println("InterruptedException received!");
        }
    }

    public static void main(String[] args) {

        // asks the user for yard dimensions
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the dimensions for a new yard: ");
        int rows = in.nextInt();
        int cols = in.nextInt();

        // prints out the new yard
        Yard yard = new Yard(rows, cols);
        Mower mower = new Mower(1, 1, DIRECTION.RIGHT);

        mower.randomizeDirection(yard);
        yard.printYard(mower);

        while (true) {
            mower.mow(yard);
            clearScreen();
            yard.printYard(mower);
            delay(500);

            // check in front of you -> if grass then move forward
            if (mower.checkGrass(yard) == '+') {
                mower.mover();
            } else {
                // turn to the right of original direction.
                mower.turnRight();
                if (mower.checkGrass(yard) == '+') {
                    // there is grass in front.
                    // move forward
                    mower.mover();
                } else {
                    // no grass to the right.
                    // turn to the left of the original direction.
                    mower.turnLeft();
                    mower.turnLeft();

                    if (mower.checkGrass(yard) == '+') {
                        // there is still some grass left to mow
                        mower.mover();
                    } else {
                        break;
                    }
                }
            }
        }
    }
}

