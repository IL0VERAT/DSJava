import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PartD {

    public static ArrayList swap(ArrayList<Integer>list, int i, int j){
        list.set(j,list.get(i));
        list.set(i,list.get(j));

        return list;
    } 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(11, 22, 33, 44, 55, 66, 77, 88, 99, 1010));

        while(true){
            System.out.println("Which indices would you like to switch (i, j): ");
            int i = in.nextInt();
            int j = in.nextInt();

        if(j > list.size() || j < 0 || i > list.size() || i < 0){
            System.out.println("Error! Please input index within range!");
            break;
        } else {
            swap(list, i, j);
            System.out.println(list);
            break;
        }
    }

        
    }
}
