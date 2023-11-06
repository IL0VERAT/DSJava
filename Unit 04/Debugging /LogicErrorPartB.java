import java.util.Scanner;
public class LogicErrorPartB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of cookies: ");
        int num = in.nextInt();
        Double discount = 0.0; //gets a starting value for the discount
            if (num > 6 && num <= 12) { //ensures that the customer will get a higher discount if the number of cookies purchased was above 12
                discount = 0.05;
            } 
            if (num > 12) {
                discount = 0.10;
            }
        System.out.println("Discount = " + discount);  
    }
    /*This program has a logic and a compile time error. 
    Firstly, discount needed to be assigned a value as their was a scenario when it did not equal anything. 
    Secondly, because of how the code was written, it would always print that the user gets a 5% discount. */

}

