//Coder: Milo Linn-Boggs Date: 2 Nov. 2023
import java.util.Scanner;
public class ThreeIntegers{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //flag that determines if numbers not in order or in order
        boolean flag = false;
        //asks user for three integers
        System.out.print("Enter three integers: ");
        //splits up the three integers into 3 variables
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();

        //determines if numbers are increasing or decreasing
        if(n2 > n1){
            //if this is true, prints out the statement 
            if(n3 > n2){
                System.out.print("Increasing and In Order");
                //sets the flag into true(meaning will be in order)
                flag = true;
            }
        } 
        //determines if the numbers are increasing or decreasing
        if (n2< n1) {
            //if this is true, prints out statement
            if(n3 < n2){
                System.out.print("Decreasing and In Order");
                //sets the flag to true(meaning will be in order)
                flag = true;
            }
        }
        //if not in order, then not in order
        if(flag == false){
            System.out.print("Not in order");
        }

    }
}