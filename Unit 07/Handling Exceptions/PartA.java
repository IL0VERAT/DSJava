import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class PartA{
public static void main(String[] args) throws FileNotFoundException {
    Scanner inKeyboard = new Scanner(System.in);
    System.out.println("Enter a file name or # to quit: ");
    boolean fileOpened = false;
    String name = inKeyboard.next();
    while (fileOpened == false && !name.trim().equals("#")) {
        try {
            File inputFile = new File(name);
            Scanner in = new Scanner(inputFile);
            while (in.hasNext()) {
                String word = in.next();
                System.out.println(word);
            }
            in.close();
            fileOpened = true;
        } catch (FileNotFoundException exception) {
            System.out.println("Error: unable to find the file named \"" + name + "\".");
            System.out.print("Enter the correct name of the file to open: ");
            name = inKeyboard.nextLine();
        }
    }
    System.out.println("Goodbye!");
}
}
