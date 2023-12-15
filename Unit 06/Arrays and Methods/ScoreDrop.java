import java.util.Scanner;
public class ScoreDrop {
    static double least = 0;

    public static void dropper(double testArrays){
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[] testValues = new double[25];
    while(true){
        for(int i = 0; i < testValues.length; i++){

            //asks the user for test scores
            System.out.print("Enter a test score (enter q to quit or y to drop the lowest test score)");
            
            //stops program if user inputs q or Q
            if(in.hasNext("q")||in.hasNext("Q")){
                break;
            }

            //eliminates the lowest score if user inputs y or Y
            if(in.hasNext("y")||in.hasNext("Y")){

            }

            //assigns the user input to the corresponding place in the array
            testValues[i] = in.nextDouble();

            //checks to see what the smallest test score is
            if(testValues[i] < least){
                least = testValues[i];
            } 
            }
        }
    }
}
