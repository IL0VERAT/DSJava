import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ExampleTryCatch{
public static void main(String[] args) throws FileNotFoundException {
    Scanner inKeyboard = new Scanner(System.in);
    boolean fileOpened = false;
    String name = "issing.txt";
    while (fileOpened == false) {
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
}
}