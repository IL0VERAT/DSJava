import org.derryfield.math.Geometry;
import java.util.Scanner;
public class Example {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        System.out.println("Enter the radius of a circle: ");
        double radius = in.nextDouble();

       double surf =  Geometry.calcSurfSphere(radius);
       double vol =  Geometry.calcVolSphere(radius);

        System.out.printf("%nThe volume of the sphere with a radius of %.2f is %.2f", radius, vol);
        System.out.printf("%nThe surface area of the sphere with a radius of %.2f is %.2f", radius, surf);
    }
    
}
