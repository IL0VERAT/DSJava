import java.util.Scanner;
public class NumericalOrder {
    public static void main(String[] args) {
    Scanner in  = new Scanner(System.in);

    final int LENGTH = 100;
    double[] values = new double[LENGTH];
    int fillRate = 0;

    boolean doLoop = true;
    while(doLoop){
        System.out.print("Enter a test score or 'q' to quit: ");

        if(in.hasNext("q")|| in.hasNext("Q")){
            doLoop = false;

        } else if (in.hasNextDouble()) {
            //check if theres space in array
            if(fillRate < values.length){
                values[fillRate] = in.nextDouble();
                fillRate++;
            } else {
                System.out.println("No more space in array");
                doLoop = false;
            }
        } else {
            //user put in erroneous input
            System.out.print("INVALID INPUT: ONLY DOUBLE VALUES OR Q TO QUIT");

            //skip over non double value
            in.next();
        }
    }
}
}
