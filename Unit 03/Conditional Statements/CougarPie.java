//Coder: Milo Linn-Boggs Date: 11 October 2023
import java.util.Scanner;
public class CougarPie{
    public static void main (String[]args) throws Exception{
        Scanner in = new Scanner(System.in);
        final double PIE_COST= 10.00; //sets price of pie at $10
        System.out.print("How many pies would you like: "); //Prompts user for amount of pies bought
        
        int pie_num = in.nextInt();
        double pie_price = PIE_COST * pie_num; //equation for the price for x # of pies
        
        if (pie_num >= 3){ //if the the user bought 3 or more pies, than runs conditional statment
             pie_price = (pie_num * PIE_COST) * 0.9; //applies a 10% discount
        }
        System.out.print("The total cost of your order is: $" + pie_price); //prints out total price
    }
}