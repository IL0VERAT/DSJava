//Coder: Milo Linn-Boggs Date: 16 Jan. 2023
import java.util.Scanner;
import java.util.ArrayList;
public class AlternatingSum {

    //method to add or subtract the numbers in the ArrayList
    public static void calculator (ArrayList<Integer> workingNum){
        int total = 0; 
        for(int i = 0; i < workingNum.size();i++){
            //adds the even index numbers
            if(i%2 == 0){
                total = total += workingNum.get(i);
            } 
            //adds the odd index numbers
            if (i%2 == 1){
                total = total -= workingNum.get(i);
            }
        }
        System.out.println(total);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> integers = new ArrayList<Integer>();
        //asks user to input integer values
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

