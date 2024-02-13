//Coder: Milo Linn-Boggs Date: Feb 9th (I believe) 2024
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class PartA{
public static void main(String[] args) throws FileNotFoundException {
    Scanner inKeyboard = new Scanner(System.in);
    //asks user to input file name or # to quit
    System.out.println("Enter a file name or # to quit: ");
    boolean fileOpened = false;
    String name = inKeyboard.next();
    //if the input is not a #, runs
    while (fileOpened == false && !name.trim().equals("#")) {
        try {
            File inputFile = new File(name);
            Scanner in = new Scanner(inputFile);
            //prints out the contents of the file
            while (in.hasNext()) {
                String word = in.next();
                System.out.println(word);
            }
            in.close();
            fileOpened = true;
            //catchs a FileNotFound Exception and asks the user to re-enter the file name
        } catch (FileNotFoundException exception) {
            System.out.println("Error: unable to find the file named \"" + name + "\".");
            System.out.print("Enter the correct name of the file to open: ");
            name = inKeyboard.nextLine();
        }
    }
    System.out.println("Goodbye!");
}
}
