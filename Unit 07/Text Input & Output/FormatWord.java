import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FormatWord {
public static void main(String[] args) throws FileNotFoundException {
    File inputFile = new File("customerdata.txt");
    Scanner in = new Scanner(inputFile);
    in.useDelimiter("[,\\n\\t\\s]+");
    System.out.println("---------------------------------------");
    System.out.println(" ID  |    Name     |     Balance ");
    System.out.println("---------------------------------------");
    int count = 0;
    while (in.hasNext()) {
        String word = in.next();
        System.out.print(word);
        count++;
    }
    in.close();
}
}

