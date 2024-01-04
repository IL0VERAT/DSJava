//Coder: Milo Linn-Boggs Date: 01/04/24
import java.util.Arrays;
import java.util.Scanner;
public class FindingTheAverage {

    //method to find the average of the inputted numbers
    public static void findAverage (int currentSize, double[] valueArray){
        double[] copyValue = Arrays.copyOf(valueArray, valueArray.length);
        double sum = 0;
        //code to find sum of values
        for(int i = 0; i < currentSize; i++){
            sum += copyValue[i];
        }
        //code to find average of values
        double total = sum/currentSize;
        //prints out average
        System.out.printf("%nThe average of the inputted numbers is %.2f.", total);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        final int numValues = 100;
        int currentSize = 0;
        double [] values = new double [numValues];
        //asks user to input numbers
        for(int i = 0; i < numValues; i++){
            System.out.print("Enter a random double values or q to quit: ");

            //checks to see if user stopped program
            if(in.hasNext("q")||in.hasNext("Q")){
                in.next();
                FindingTheAverage.findAverage(currentSize, values);
                break;
            } else { 
                values[i] = in.nextDouble();
                currentSize++;
            }

        }
    }
}