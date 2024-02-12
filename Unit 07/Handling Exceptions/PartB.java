import java.util.Scanner;
import java.io.File;
public class PartB {
    public static void main(String[] args) {
        Scanner in;
        try {
            File input = new File("birthyears.txt");
            in = new Scanner(input).useDelimiter("[,\\s]+");
        } catch (Exception FileNotFoundException){
            System.out.println("File not found");
            in = new Scanner(System.in);
        }

        while(in.hasNext()){
            String name = in.next();
            try{
                int age = Integer.parseInt(in.next());
                System.out.println(name + "'s birthday is " + age);
            } catch (Exception NumberFormatException){
                System.out.println(name + "'s birthday is unknown");
            }
        }
        in.close();
  }
}
