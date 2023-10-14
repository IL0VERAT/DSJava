import java.util.Scanner;
public class CougarCafeEnum{
    public enum DayOfWeek {MONDAY, OTHER_DAY}
    public enum AgeOfPerson {CHILD, ADULT, SENIOR}
    public static void main (String[]args)throws Exception{
        Scanner in = new Scanner(System.in);
        System.out.print("What day of the week is it? (0 = Sunday ... 6 = Saturday) ");
        int day = in.nextInt();
        DayOfWeek today;
        
        System.out.print("What is the age of the customer? (0 = Child, 1 = Adult, 2 = Senior Citizen) ");
        int age = in.nextInt();
        AgeOfPerson stage;

        System.out.print("What is the cost of the customers meal: ");
        double price = in.nextDouble();
        if (day == 1){
            today = DayOfWeek.MONDAY;
        }else{
            today = DayOfWeek.OTHER_DAY;
        }

        if (age == 0){
            stage = AgeOfPerson.CHILD;
        }
        if (age == 1){
            stage = AgeOfPerson.ADULT;
        }
        if (age == 2){
            stage = AgeOfPerson.SENIOR;
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
        

    