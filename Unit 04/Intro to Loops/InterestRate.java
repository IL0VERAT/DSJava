//Coder: Milo Linn-Boggs Date: 30 October 2023
import java.util.Scanner;
public class InterestRate {
    public static void main(String[]args){
    Scanner in = new Scanner(System.in);
    System.out.print("What is the interest rate (APR)? Please input as a decimal value: "); //asks user for an interest rate percentage, as a decimal value. 
    double interest_rate = in.nextDouble(); // represents the interest rate
    System.out.print("What is the initial balance amount in dollars: "); //asks user for the initial balance of thier account.
    double initial_balance = in.nextDouble(); //represents the initial amount

    double earnings; //represents the earnings of the users account with inputted interest rate
    System.out.print("Year |  Int Earned ($)  |  Balance($) "); //lines 12 and 13: formatting 
    System.out.printf("%n--------------------------------------");
    
    for (int y = 1;y < 6;y++){ //for loop: sets y (year) equal to 1, then adds 1 to that everytime it loops, for as long as y is less than 6. 
        earnings = initial_balance * interest_rate; //calculates the earnings
        initial_balance = initial_balance + earnings; //calculates the new intital balance to recheck every loop. 
        System.out.printf("%n%d|%,16.02f|%,20.02f", y, earnings, initial_balance); //prints out the results of the loop. 
    }
    }
    }
    

