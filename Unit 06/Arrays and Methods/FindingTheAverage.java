import java.util.Arrays;
import java.util.Scanner;
public class FindingTheAverage {
    public static void findAverage (int currentSize, double[] valueArray){
        double[] copyValue = Arrays.copyOf(valueArray, valueArray.length);
        double sum = 0;
        for(int i = 0; i < currentSize; i++){
            sum += copyValue[i];
        }
        double total = sum/currentSize;
        System.out.printf("%nThe average of the inputted numbers is %.2f.", total);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        final int numValues = 100;
        int currentSize = 0;
        double [] values = new double [numValues];
        for(int i = 0; i < numValues; i++){
            System.out.print("Enter a random double values or q to quit: ");

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