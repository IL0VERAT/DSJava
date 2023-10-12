//Coder: Milo Linn-Boggs Date: 11 October 2023
import java.util.Scanner;
public class CougarCookie {
    public static void main (String[]args) throws Exception{
        Scanner in = new Scanner(System.in);
        final double COOKIE_PRICE = 0.99; //sets price of 1 cookie
        System.out.print("How many cookies do you have: "); //prompts user for # of cookies purchased
        int num_cookies = in.nextInt();
        double cookie_cost = num_cookies * COOKIE_PRICE; //basic equation for total cost
        if (num_cookies > 24){ //calculates whether they bought more than 24 cookies and applies 15% discount to total purchase
            cookie_cost = (num_cookies * COOKIE_PRICE) * 0.85;
        } else if (num_cookies > 12){//calculates whether they bought more than 12 cookies and applies 5% discount to total purchase
            cookie_cost = (num_cookies * COOKIE_PRICE) * 0.95;
        } else if (num_cookies > 6){//calculates whether they bought more than 6 cookies and applies 2.5% discount to total purchase
            cookie_cost = (num_cookies * COOKIE_PRICE) * 0.985;
        }
        System.out.printf("The total cost of your cookies is %.2f dollars", cookie_cost); //displays total cost of purchase 
    }
}
