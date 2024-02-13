import java.util.Scanner;
public class Throw{
    public static int getAge (Scanner in){
        System.out.print("Tell me your age: ");
        int age = in.nextInt();
        if(age <= 0){
            throw new IllegalArgumentException("Age must be greater than zero!");
        } else {
            return age;
        }
    }
    public static void main(String[] args) {
       Scanner in = new Scanner (System.in);
       try {
        int age = getAge(in);
        System.out.println("Your age is " + age);
       } catch (Exception e){
        System.err.println("An error occured!");
        System.out.println(e.getMessage());
       }
    }
}