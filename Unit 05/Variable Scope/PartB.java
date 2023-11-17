//Coder: Milo Linn-Boggs Date: 17 Nov. 2023
import java.util.Scanner;
public class PartB {
    
    //custom method smallest: used to determine what number is the smallest of three numbers
    public static double smallest (double x, double y, double z){

        //used to determine what number is the smallest
        if(x < y){
            if(x < z){
                //if the number represented by x is the smallest, print x
                return x; 
            }
        } 
        else if(y < z){
            //if the number represented by y is the smallest, print y
            return y;
        } 
        else if(z < y){
            if(z < x){
                //if the number represented by z is the smallest, print z
                return z;
            }
        }
        //if all the numbers are the same, print this 
        return z; }
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);

            //asks the user for three numbers
            System.out.print("Enter three numbers: ");
            
            //assigns the users inputted numbers to three variables
            double a = in.nextDouble();
            double b = in.nextDouble();
            double c = in.nextDouble();

            //pushs the users inputs to the custom method
            double answer = smallest(a, b, c);

            //prints out the answer
            System.out.println(answer);
    }
}
