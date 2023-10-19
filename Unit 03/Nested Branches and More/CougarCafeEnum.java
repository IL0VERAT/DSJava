import java.util.Scanner;
public class CougarCafeEnum{
    public enum DayOfWeek {MONDAY, OTHER_DAY,ERROR}
    public enum AgeOfPerson {CHILD, ADULT, SENIOR}
    public static void main (String[]args)throws Exception{
        Scanner in = new Scanner(System.in);
        System.out.print("Is today Monday? Print Yes or No.");
        String day = in.nextLine();
        DayOfWeek today;
        
        System.out.print("What is the age of the customer? ");
        int age = in.nextInt();
        AgeOfPerson stage;


        System.out.print("What is the cost of the customers meal: ");
        double price = in.nextDouble();
        if (day.equals("Yes")){
            today = DayOfWeek.MONDAY;
        }
        if(day.equals("No")){
            today = DayOfWeek.OTHER_DAY;
        }else{
            today = DayOfWeek.ERROR; 
            if(today == DayOfWeek.ERROR){
                System.out.print("Error! Put in a correct answer for question.");
                price = 0;
            }
        }

        if (age <13){
            stage = AgeOfPerson.CHILD;
        }
        if (age >= 50){
            stage = AgeOfPerson.SENIOR;
        }
        else{
            stage = AgeOfPerson.ADULT;
        }
       
        if (today == DayOfWeek.OTHER_DAY){
            if(stage == AgeOfPerson.ADULT){
                price = price * 0.95;
            }
            if(stage == AgeOfPerson.SENIOR){
                price = price * 0.925;
            }

        } else if (today == DayOfWeek.MONDAY){
            if(stage == AgeOfPerson.ADULT){
                price = price * 0.95;
            }
            if(stage == AgeOfPerson.CHILD){
                price = price * 0.925;
            }
            if(stage == AgeOfPerson.SENIOR){
                price = price * 0.85;
            }
        }
        System.out.printf("The cost of the customers meal is: $%.2f ", price);
         
     }
 }
        

    