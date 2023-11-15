import java.util.Scanner;
public class RadiusOfSquare {
    public static double radius(double x){
        double volume = (4.0/3.0) * Math.PI * (x * x * x);
        return volume;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the radius of the sphere: ");
        double input_radius = in.nextDouble();
        double radius = radius(input_radius);
        System.out.printf("%.2f",radius);
    }
}
