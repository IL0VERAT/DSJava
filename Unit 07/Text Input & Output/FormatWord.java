import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FormatWord {
public static void main(String[] args) throws FileNotFoundException {
    File inputFile = new File("customerdata.txt");
    Scanner in = new Scanner(inputFile);
    in.useDelimiter("[,\\n\\t\\s]+");
    System.out.println("---------------------------------------");
    System.out.println("   ID  |    Name     |     Balance ");
    System.out.println("---------------------------------------");
    while (in.hasNext()) {
        // read in id
        int id = in.nextInt();
        System.out.printf("%06d | ",id);
        // read in name
        String name = in.next();
        System.out.printf("%11s | ",name);
        // read in balance;
        double balance = in.nextDouble();
        System.out.printf("$%15.2f",balance);
        System.out.println("");
    }
    in.close();
}
}

