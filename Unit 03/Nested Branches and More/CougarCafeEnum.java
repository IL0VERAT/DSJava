//Coder: Milo Linn-Boggs Date: 19 October 2023
import java.util.Scanner;
public class CougarCafeEnum{
    public enum DayOfWeek {MONDAY, OTHER_DAY,ERROR} //enum type for days
    public enum AgeOfPerson {CHILD, ADULT, SENIOR, ERROR} //enum type for age of customer
    public static void main (String[]args)throws Exception{
        Scanner in = new Scanner(System.in);
        System.out.print("Is today Monday? Print Yes or No."); //asks user if it is monday
        String day = in.nextLine();
        DayOfWeek today;
        
        
        System.out.print("What is the age of the customer? "); //asks user for the age of the customer
        int age = in.nextInt();
        AgeOfPerson stage;


        System.out.print("What is the cost of the customers meal: "); //asks for the cost of the customers meal
        double price = in.nextDouble();
        if (day.toLowerCase().equals("yes")){ //if user said yes to day question, sets variable to enum DayOfWeek.MONDAY
            today = DayOfWeek.MONDAY;
        } else if(day.toLowerCase().equals("no")){ //if user said no to day question, sets variable to enum DayOfWeek.OTHER_DAY
            today = DayOfWeek.OTHER_DAY;
        } else{
            today = DayOfWeek.ERROR; 
            if(today == DayOfWeek.ERROR){
                System.out.print("Error! Put in a correct answer for question.");//if user did not put yes or no, prints out error statement
                price = 0;
            }
        }

        if (age < 13){ //if the inputted age is < 13, then sets stage variable to enum AgeOfPerson.CHILD
            stage = AgeOfPerson.CHILD;
        }
        else if (age >= 50){ //if the inputted age is >= 50, then sets the stage variable to enum AgeOfPerson.SENIOR
            stage = AgeOfPerson.SENIOR;
        }
        else{ //if age is anything else, than sets stage variable to enum type AgeOfPerson.ADULT
            stage = AgeOfPerson.ADULT;
        }
       
        if (today == DayOfWeek.OTHER_DAY){ //if it is not Monday, and the age of customer is < 13, than get a 5% discount 
            if(stage == AgeOfPerson.CHILD){
                price = price * 0.95;
            }
            else if(stage == AgeOfPerson.SENIOR){ //if it is not Monday, and the age of the customer is >= 50, then get a 7.5% discount
                price = price * 0.925;
            }

        } else if (today == DayOfWeek.MONDAY){ // if it is Monday, and the age of the customer is between 13 and 49, then get a 5% discount
            if(stage == AgeOfPerson.ADULT){
                price = price * 0.95;
            }
            else if(stage == AgeOfPerson.CHILD){ // if it is Monday, and the age of the customer is < 13, then get a 7.5% discount
                price = price * 0.925;
            }
            else if(stage == AgeOfPerson.SENIOR){ // if it is Monday, and the age of the customer is >= 50, then get 15% discount
                price = price * 0.85;
            }
        }
        System.out.printf("The cost of the customers meal is: $%.2f%n ", price); //prints out cost of meal with appropriate discount
         
     }
 }
        

    