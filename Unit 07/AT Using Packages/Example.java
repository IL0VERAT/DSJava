//Coder: Milo Linn-Boggs Date: 
//imports the custom package
import org.derryfield.math.Geometry;
import java.util.Scanner;
public class Example {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        //asks the user for the radius of a circle
        System.out.println("Enter the radius of a circle: ");
        double radius = in.nextDouble();

        //uses the custom functions of the geometry class
       double surf =  Geometry.calcSurfSphere(radius);
       double vol =  Geometry.calcVolSphere(radius);

       //prints out the answers
        System.out.printf("%nThe volume of the sphere with a radius of %.2f is %.2f", radius, vol);
        System.out.printf("%nThe surface area of the sphere with a radius of %.2f is %.2f", radius, surf);
    }
    
}
