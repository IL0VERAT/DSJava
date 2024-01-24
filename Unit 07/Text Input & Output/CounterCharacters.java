import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CounterCharacters{
public static void main(String[] args) throws FileNotFoundException {
    File inputFile = new File(" characters.txt");
    Scanner in = new Scanner(inputFile);
    in.useDelimiter("");
    int count = 0;
    int digitCounter = 0;
    while (in.hasNext()) {
        char c = in.next().charAt(0);
        System.out.println(c);
        count++;
        //== true not needed
        if(Character.isDigit(c)){
            digitCounter = digitCounter + 1;
        }
    }
    System.out.printf("count = %d%n", count);
    System.out.printf("digitCounter = %d%n", digitCounter);
}
}
