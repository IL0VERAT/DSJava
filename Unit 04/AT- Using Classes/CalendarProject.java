import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;
public class CalendarProject{
    public static void main(String[] args) {
    LocalDateTime localDate = LocalDateTime.now();

    DateTimeFormatter dateformatter1 = DateTimeFormatter.ofPattern("MM dd yyyy");
    System.out.println(dateformatter1.format(localDate));
   

    }     
}