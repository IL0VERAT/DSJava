import java.util.Scanner;
public class HourMinuteSecond {
    public static void main (String[]args) throws Exception{
        Scanner in = new Scanner(System.in);
        System.out.print("Input an amount of time in seconds: ");
        int originaltime = in.nextInt();

        int mathhour = originaltime/3600;
        if (mathhour == 0){
            int minremain = originaltime%3600;
            int mathminute = minremain/60;
        }
    }
}