import java.util.Scanner;
import java.util.Arrays;
public class NumericalOrder {
    public static void main(String[] args) {
    Scanner in  = new Scanner(System.in);

    final int LENGTH = 10;
    int[] values = new int[LENGTH];
    int fillRate = 0;

    boolean doLoop = true;
    while(doLoop){
        System.out.print("Enter a number or 'q' to quit: ");

        if(in.hasNext("q")|| in.hasNext("Q")){
            doLoop = false;

        } else if (in.hasNextDouble()) {
            //check if theres space in array
            if(fillRate < values.length){
                values[fillRate] = in.nextInt();
                fillRate++;
            } else {
                System.out.println("No more space in array");
                doLoop = false;
            }
        } else {
            //user put in erroneous input
            System.out.print("INVALID INPUT: ONLY INTEGER VALUES OR Q TO QUIT");
            //skip over non double value
            in.next();
        }
    }
    if(doLoop == false){
        System.out.print("*");
        for(int i = 0; i < fillRate; i++){
            System.out.print(values[i] + "*");
        }
        Arrays.sort(values, 0, fillRate);  
        System.out.println(""); 
        for(int j = fillRate; j > 0; j--){
            System.out.print(values[j - 1]);
            if(j > 1){
                System.out.print(",");
            }
        }
    }
    


}
}