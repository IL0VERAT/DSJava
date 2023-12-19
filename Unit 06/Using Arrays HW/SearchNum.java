import java.util.Scanner;
public class SearchNum {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);

    final int LENGTH = 50;
    int[] values = new int[LENGTH];
    int fillRate = 0;
    int numCounter = 0;
    int userNumSearch;

    boolean doLoop = true;
    while(doLoop){
        System.out.print("Enter a number or 'q' to quit: ");

        if(in.hasNext("q")|| in.hasNext("Q")){
            doLoop = false;
            //skip over the q
            in.next();

        } else if (in.hasNextDouble()) {
            //check if theres space in array
            if(fillRate < 20){
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
    if (doLoop == false){
        System.out.print("What number would you like to search for? ");
        userNumSearch = in.nextInt();
        for(int i = 0; i < fillRate; i++){
            if(values[i] == userNumSearch){
                numCounter++;
            }
       }
       System.out.print("The number you searched for appeared " + numCounter + " times.");
    }
}
}
