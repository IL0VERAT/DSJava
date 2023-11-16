//Coder: Milo Linn-Boggs Date: 15 Nov. 2023
import java.util.Scanner;
class RadiusOfSquare {
    /**
     * 
     * @param x the radius of the square
     * @return the volume
     */
    private static double radius(double x){
        //calculations for the volume of a sphere
        double volume = (4.0/3.0) * Math.PI * Math.pow(x, 3);
        //returns the result of the calculations
        return volume;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //asks the user for the radius of the sphere
        System.out.print("Enter the radius of the sphere: ");
        double input_radius = in.nextDouble();

        //copy of users input is sent to the method (represents double x) to calculate answer
        double radius = radius(input_radius);
        //prints out the answer
        System.out.printf("%.2f",radius);
    }
}
