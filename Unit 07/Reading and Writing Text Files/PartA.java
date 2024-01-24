//Coder: Milo Linn-Boggs Date: 23 Jan. 2023
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class PartA {
    // method to find the lowest temp value
    public static void printer(ArrayList<Integer> temps, Integer least) {
        System.out.printf("Temperature Values: %n");

        // places an arrow to the right of the lowest values
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

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("temps.txt");
        Scanner in = new Scanner(inputFile);
        ArrayList<Integer> temps = new ArrayList<Integer>();
        Integer least = 0;
        while (in.hasNext()) {
            //determines the starting value for the lowest calculator
            int score = in.nextInt();
            temps.add(score);
            if (temps.size() < 1) {
                least = score;
            } else if (score < least) {
                least = score;
            }
        }
        in.close();
        PartA.printer(temps, least);
    }
}
