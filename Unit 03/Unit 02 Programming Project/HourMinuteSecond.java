//Coder: Milo Linn-Boggs Date: 06 October 2023
import java.util.Scanner; //imports scanner class
public class HourMinuteSecond {
    public static void main (String[]args) throws Exception{
        Scanner in = new Scanner(System.in);
        System.out.print("Input an amount of time in seconds: "); //asks user for a time in seconds
        int originaltime = in.nextInt();
        
        //Please note: Sources consulted for int minutes and seconds: https://stackoverflow.com/questions/6118922/convert-seconds-value-to-hours-minutes-seconds#:~:text=hours%20%3D%20totalSecs%20%2F%203600%3B%20minutes,)%20in%20the%20string%2C%20though.
        int hours = originaltime/3600; //divides user input by 3600 to get # of hours
        int minutes = (originaltime%3600)/60; //divides user input by modulo 3600 to get remainder from # of hours. Then divides by 60 to get # of seconds
        int seconds = originaltime%60; //takes user input and takes remainder of a division by 60

        System.out.printf("Your converted time in hours, minutes and seconds is %d:%d:%d", hours, minutes, seconds); //prints our result in organized format

    }
}