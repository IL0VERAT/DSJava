import java.util.Scanner;
import java.util.ArrayList;
public class AlternatingSum {
    public static void calculator (ArrayList<Integer> workingNum){
        int total = 0; 
        for(int i = 0; i < workingNum.size();i++){
            if(i%2 == 0){
                total = total += workingNum.get(i);
            } 
            if (i%2 == 1){
                total = total -= workingNum.get(i);
            }
        }
        System.out.println(total);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> integers = new ArrayList<Integer>();
        //asks user to input tests scores 
        while (true) {
            System.out.println("Enter a integer value or q to quit: ");

            //if Q or q is inputted, program stops
            if (in.hasNext("q")||in.hasNext("Q")) {
                in.next();
                break;
            } else {
                integers.add(in.nextInt());
            }
        }
        AlternatingSum.calculator(integers);

    }
}

