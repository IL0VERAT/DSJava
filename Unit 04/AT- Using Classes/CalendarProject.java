import java.time.LocalDate;
import java.time.DayOfWeek;
public class CalendarProject{
    public static void main(String[] args) {
    LocalDate rightNow = LocalDate.now();
    int today = rightNow.getDayOfMonth();
    //citation: stolen from Mr. Eng
    LocalDate date = rightNow.getDayOfMonth(today - 1);
    int firstNumber;
    int rowNumber = 1;
    int colNumber = 1;
    int lastDay = rightNow.lengthOfMonth();

    DayOfWeek firstDay = date.getDayOfWeek();

    if(firstDay == DayOfWeek.MONDAY){
        firstNumber = 1;
    } 
    else if(firstDay == DayOfWeek.TUESDAY){
        firstNumber = 2;
    }
    else if(firstDay == DayOfWeek.WEDNESDAY){
        firstNumber = 3;
    }
    else if(firstDay == DayOfWeek.THURSDAY){
        firstNumber = 4;
    }
    else if(firstDay == DayOfWeek.SATURDAY){
        firstNumber = 5;
    }


   

    }     
}