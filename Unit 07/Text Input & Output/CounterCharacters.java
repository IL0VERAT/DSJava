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
    int letter = 0;
    while (in.hasNext()) {
        char c = in.next().charAt(0);
        System.out.println(c);
        count++;
        if(Character.isDigit(c)){
            digitCounter = digitCounter + 1;
        }
        if(Character.isLetter(c)){
            letter = letter + 1;
        }
    }
    System.out.printf("Count = %d%n", count);
    System.out.printf("Letters = %d%n", letter);
    System.out.printf("Digits = %d%n", digitCounter);
}
}
