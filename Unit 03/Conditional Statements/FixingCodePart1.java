//Coder: Unknown Date: 11 October 2023
import java.util.Scanner;
public class FixingCodePart1 {
    public static void main (String[]args) throws Exception{
        // prompt user for age.
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = input.nextInt();
        // are they lucky?
        if (age == 13) {//have to put == for it to ask whether a variable is equal to this number
        System.out.println("Lucky 13!");
        }
    }
}
