//Coder: Milo Linn-Boggs Date: 23 Jan. 2023

//imports the needed packages
import java.time.LocalDate;
import java.time.LocalTime;
public class DateAndTime{
    public static void main(String[] args) {
        
        //prints the current date
        LocalDate today = LocalDate.now();
        System.out.println("Todays Date: " + today);

        //prints the current time
        LocalTime time = LocalTime.now();
        System.out.println("Current Time: " + time);
    }
}