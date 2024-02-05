import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ExampleTryIt{
public static void main(String[] args) {//don't need to throw exception
    Scanner inKeyboard = new Scanner(System.in);
    boolean fileOpened = false;
    String name = "ryIt.txt";
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
            System.err.println("Error: unable to find your stupid file.");
            System.err.println(exception.getMessage());
            return;
        }
    }
}

    
}
