import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FormatWord {
   public static void main(String[] args) throws FileNotFoundException {
       File inputFile = new File("customerdata.txt");
       Scanner in = new Scanner(inputFile);
       in.useDelimiter("[,\\s\\t\\n]+");
       int count = 0;
       while (in.hasNext()) {
           String word = in.next();
           System.out.println(word);
           count++;
       }
       System.out.printf("%d words were scanned in.%n", count);
       in.close();
   }
}
