import java.util.Scanner;
public class CalAvg{
    public static double average(double a, double b) {
       double calculator = (a + b)/2.0;
       return calculator;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a double values: ");
        double x = in.nextDouble();
        
        System.out.print("Enter a double values: ");
        double y = in.nextDouble();

        double average = average(x, y); //BETTER??
        System.out.println(average); 
    }
}