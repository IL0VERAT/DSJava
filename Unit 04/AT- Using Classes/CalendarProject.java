//Coder: Milo Linn-Boggs Date: 15 Nov. 2023
//imports the needed classes 
import java.time.LocalDate;
import java.time.DayOfWeek;
public class CalendarProject{
    public static void main(String[] args) {
    //creates an LocalDate object - "start of the program" 
    LocalDate rightNow = LocalDate.now();

    //gets the current day of the month
    int today = rightNow.getDayOfMonth();
    LocalDate date = rightNow.minusDays(today - 1);

    //gets the day of the week(in an enum type)
    DayOfWeek dayOfWeek = date.getDayOfWeek();
    //converts enum type to an integer
    int dayNumber = dayOfWeek.getValue();
   
    //prints out the header of the calender
    System.out.println("Mon Tue Wed Thu Fri Sat Sun ");
    System.out.println("----------------------------");

    //creates the spaces between the numbers of the calender
    for (int i = 1; i < dayNumber; i++){
        System.out.print("    ");
    }

    //determines what month it is 
    int currMonth = rightNow.getMonthValue();
 
    //loop for the formatter. runs until the end of the current month 
    while(date.getMonthValue() == currMonth){
        //prints out the formatted days
        System.out.printf("%3d", date.getDayOfMonth());
        //
        if(date.getDayOfMonth() == rightNow.getDayOfMonth()){
            System.out.print("*");
        }
        else {
            System.out.print(" ");
        }

        if(dayNumber == 7){
            System.out.println();
        }

        date = date.plusDays(1);

        dayOfWeek = date.getDayOfWeek();
        dayNumber = dayOfWeek.getValue();
    }
    
    System.out.println();
    }     
}