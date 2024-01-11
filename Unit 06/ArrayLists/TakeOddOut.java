//Coder: Milo Linn-Boggs Date: 11 Jan. 2024
import java.util.Scanner;
import java.util.ArrayList;
public class TakeOddOut {
    //method to remove odd numbers and print out list once finished
    public static void takeOut(ArrayList<Integer> nums){
        int i = 0;
        System.out.println("Here are the inputted numbers with no odds: ");
        while(i < nums.size()){
            if(Math.abs(nums.get(i)%2) == 1){
                nums.remove(i);
            } else {
                System.out.println(nums.get(i));
                i++;
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<Integer>();
        //asks user for variables of Integer type
        while (true) {
            System.out.println("Enter a number of Integer type: ");

            //code stops of q or Q inputted
            if (in.hasNext("q") || in.hasNext("Q")) {
                in.next();
                break;
            } else {
               nums.add(in.nextInt());
            }

        }
        TakeOddOut.takeOut(nums);
    }
}
