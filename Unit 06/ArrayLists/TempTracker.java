import java.util.Scanner;
import java.util.ArrayList;

public class TempTracker {
    public static void printer(ArrayList<Integer> temps, Integer least) {
        System.out.printf("Temperature Values: %n");

        for (int i = 0; i < temps.size(); i++) {
            System.out.print(temps.get(i));
            if (temps.get(i) == least) {
                System.out.print(" <== ");
                System.out.println("");
            } else {
                System.out.println("");
            }

        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> temps = new ArrayList<Integer>();
        Integer least = 0;
        while (true) {
            System.out.println("Enter a temperature: ");

            if (in.hasNext("q") || in.hasNext("Q")) {
                in.next();
                break;
            } else {
                Integer val = in.nextInt();
                if(temps.size() < 1){
                    least = val;
                } else if (val < least) {
                    least = val;
                }
                temps.add(val);
            }

        }
        TempTracker.printer(temps, least);

    }
}
