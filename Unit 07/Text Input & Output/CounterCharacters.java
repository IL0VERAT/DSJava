
//Coder: Milo Linn-Boggs Date: 26 Jan. 2023
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/*program takes a .txt file and prints out each charcter on a seperate
line, then prints the total # of characters, total # of letters, and the total # of digits*/
public class CounterCharacters {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("LittleLamb.txt");
        Scanner in = new Scanner(inputFile);
        in.useDelimiter("");
        int count = 0;
        int digitCounter = 0;
        int letter = 0;
        while (in.hasNext()) {

            // prints out the characters
            char c = in.next().charAt(0);
            System.out.print(c);

            // updates the total count
            count++;

            // checks if character is a digit
            if (Character.isDigit(c)) {
                digitCounter = digitCounter + 1;
            }

            // checks if character is a letter
            if (Character.isLetter(c)) {
                letter = letter + 1;
            }
        }
        // prints out results
        System.out.printf("Count = %d%n", count);
        System.out.printf("Letters = %d%n", letter);
        System.out.printf("Digits = %d%n", digitCounter);
    }
}
