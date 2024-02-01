import java.util.Scanner; 
public class Prep1{
    public static void average(double x, double y ){
        double result = (x + y)/2;
        System.out.println("The average is "+result);

    }
    //int...values = variable number of values
    //remeber +=
    public static double difference(double x, double y){
        double result;
        if(x > y){
            result = x-y;
        } else if (y > x) {
            result = y - x;
        } else {
            result = 0;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);

        System.out.print("Enter two double values: ");
        double x = in.nextDouble();
        double y = in.nextDouble();

        average(x, y);
        System.out.println("The difference is " + difference(x, y));
    }
}