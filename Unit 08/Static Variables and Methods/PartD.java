import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PartD {

    //static method to swap the ArrayList elements
    public static ArrayList swap(ArrayList<Integer>list, int i, int j){
        int temp = list.get(j);
        list.set(j,list.get(i));
        list.set(i,temp);

        return list;
    } 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        boolean flag;

        while(true){
            flag = false;

            //asks user which indices they would like to switch
            System.out.println("Which indices would you like to switch (i, j): ");
            int i = in.nextInt();
            int j = in.nextInt();

            //checks to see if in correct range, if so, then throws error message
        if(j > list.size() || j < 0 || i > list.size() || i < 0){
            System.out.println("Error! Please input index within range!");
            flag = true;

            //if no invalid responses, than switches elements
        } else if (flag == false) {
            swap(list, i, j);
            System.out.println(list);
            break;
        }
    }

        
    }
}
