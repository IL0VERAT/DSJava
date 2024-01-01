import java.util.Scanner;
public class FindingTheAverage {
    public static void findAverage (int currentSize, double[] valueArray){
        for(int i = 0; i < currentSize; i++){
            value[]
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        final int numValues = 100;
        int currentSize = 0;
        double [] values = new double [numValues];
        while(true){
            for(int i = 0; i < numValues; i++){
                System.out.print("Enter a random double values or q to quit.");

            if(in.hasNext("q")||in.hasNext("Q")){
                    break;
            } else {
                values[i] = in.nextDouble();
                currentSize++;
            }  
        }

        System.out.println("The program will now average the inputted values and print the result.");

        FindingTheAverage.findAverage(currentSize, values);

    }
}
}
