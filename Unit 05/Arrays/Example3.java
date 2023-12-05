import java.util.Scanner;
public class Example3 {
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
        //loop through and calculate average and print out formatted output
        double avg = 0;
        for(int i = 0; i < fillRate; i++){
            avg = avg + values[i];
            System.out.printf("Test Score # %3d: %6.02f%n", i+1, values[i]);

        }
        avg = avg / fillRate;
        System.out.printf("Average = %.02f%n", avg);
    }
}
