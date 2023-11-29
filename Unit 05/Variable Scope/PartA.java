//Answer to Problem: There is a duplicate local variable in this code. Input is assigned to two different methods and as different types. 
import java.util.Scanner;

public class PartA{
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
      System.out.print("What is your first name? ");
      String name = in.next(); //change the variable to a more informative name that is unique
      System.out.println("Hello, " + name);
      System.out.print("How old are you? ");
      int age = in.nextInt(); //change the variable here as well. 
      age++;
      System.out.println("Next year, you will be " + age);

    }
}