import java.util.Scanner;
public class InterestRate {
    public static void main(String[]args){
    Scanner in = new Scanner(System.in);
    System.out.print("What is the interest rate (APR)? Please input as a decimal value: ");
    double interest_rate = in.nextDouble();
    System.out.print("What is the initial balance amount in dollars: ");
    double initial_balance = in.nextDouble();
    double total;
    double earnings;
    int y = 1;
    for (;y < 6;y++){
        earnings = (initial_balance * interest_rate);
        total = initial_balance + earnings;
        System.out.printf("%n%d|%,12.02f|%,12.02f", y, earnings, total);
    }
    }
    }
    

