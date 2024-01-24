import java.time.LocalDate;
import java.time.LocalTime;
public class DateAndTime{
    public static void main(String[] args) {
        
        LocalDate today = LocalDate.now();
        System.out.println("Todays Date: " + today);

        LocalTime time = LocalTime.now();
        System.out.println("Current Time: " + time);
    }
}