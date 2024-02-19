import java.util.Scanner;
public class PartA{
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        System.out.print("Enter you name: ");
        System.out.println("Your name is " + in.nextLine());
        System.out.print("Enter your age: ");
        System.out.println("Your age is " + in.nextInt());
    }
}