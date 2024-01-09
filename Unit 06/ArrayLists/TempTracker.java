import java.util.Scanner;
import java.util.ArrayList;
public class TempTracker {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Double> temps = new ArrayList<Double>();
        while (true) {
            System.out.println("Enter a temperature: ");

            if (in.hasNext("q")||in.hasNext("Q")) {
                in.next();
                break;
            } else {
                temps.add(in.nextDouble());
            }
        }

    }
}
