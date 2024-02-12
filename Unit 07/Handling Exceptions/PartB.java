//Coder: Milo Linn-Boggs Date: 11 Feb. 2024 (SORRY THIS IS A WEE BIT LATE)
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class PartB {
    public static void main(String[] args) {
        Scanner in;
        //checks for FileNotFoundException
        try {
            File input = new File("birthyears.txt");
            in = new Scanner(input).useDelimiter("[,\\s]+");
        } catch (FileNotFoundException Exception){
            System.out.println("File not found");
            in = new Scanner(System.in);
        }

        //Prints out data and checks for NumberFormatException
        while(in.hasNext()){
            String name = in.next();
            try{
                int age = Integer.parseInt(in.next());
                System.out.println(name + "'s birthday is " + age);
            } catch (NumberFormatException Exception){
                System.out.println(name + "'s birthday is unknown");
            }
        }
        in.close();
  }
}
