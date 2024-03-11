//Coder: Milo Linn-Boggs Date: Mar. 11 2024
import java.util.Scanner;
public class PartA {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);

        //asks user to input a double value
        System.out.print("Enter a random double value: ");

        //multiples the value by PI
        double user_value_pi = in.nextDouble() * Math.PI;

        //rounds the new value
        double user_value_round = Math.round(user_value_pi);

        //prints out response
        System.out.printf("This is the user input multiplied by pie: %3.2f and here is the rounded value: %3.2f" , user_value_pi, user_value_round);

    }
}
