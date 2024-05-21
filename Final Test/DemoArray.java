import java.util.ArrayList;
import java.awt.Rectangle;

public class DemoArray {
    public static void printArray(int[]array){
        //if you modify here, will actually stick as passed by reference
        for(int num:array){
            System.out.println(num);
        }
    }
    public static void main(String[] args) {
        ArrayList<Rectangle> list = new ArrayList<>();
        Rectangle rect1 = new Rectangle();
        list.add(rect1);
        System.out.println(list.get(0));
        //int[] values = {8,6,7,5,3,0,9};
        //int total = 0;
        //int max = values[0]; //works for this one, but may cause issue if array not filled
        //printArray(values);
        /* 
        for(int i = 0; i < values.length; i++){
            //System.out.println(values[i]);
            if(values[i]>max){
                max = values[i];
            }
            total = values[i] + total;
        }
        
       double avg = total/values.length;
       */
       //System.out.printf("ave = %.2f%n", avg);
        //OR

        //enhanced loop
        //for(int number /*local variable that takes value of value in array */:values){
            //System.out.println(number);
        }
    }

