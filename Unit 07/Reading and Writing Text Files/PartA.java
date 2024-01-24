import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class PartA {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("temps.txt");
        Scanner in = new Scanner(inputFile);
        ArrayList<Integer> temps = new ArrayList<Integer>();
        Integer least = 0;
        while (in.hasNext()) {
            int score = in.nextInt();
            if (temps.size() < 1) {
                least = score;
            } else if (score < least) {
                least = score;
            }
            temps.add(score);
        }
        in.close();
    }
}

