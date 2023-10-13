import java.util.Scanner;
public class CougarCafe{
    public static void main (String[]args)throws Exception{
        Scanner in = new Scanner(System.in);
        System.out.print("Is it a Monday? Please print 'y' for yes or 'n' for no: ");
        String day = in.nextLine();
        
        System.out.print("What is the age of the customer: ");
        int age = in.nextInt();

        System.out.print("What is the cost of the customers meal: ");
        double price = in.nextDouble();
       
        if (day.equals("n")){
            if (age < 13){
                price = price * 0.95;
            }
            if (age >= 50){
                price = price * 0.925;
            }

        } else if (day.equals("y")){
            if (age<=49 && age >= 13){
                price = price * 0.95;
            }
            if(age < 13){
                price = price * 0.925;
            }
            if(age >= 50){
                price = price * 0.85;
            }
        }
        System.out.printf("The cost of the customers meal is: $%.2f ", price);
         
     }
 }
        

    
