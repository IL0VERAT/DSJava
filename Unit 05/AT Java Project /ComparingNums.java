import java.util.Arrays;
import java.util.Scanner;
public class ComparingNums{
    public static void whoIfFirst(int[] array1, int[] array2){
        if(array1[0] > array2[0]){
            System.out.printf("The bigger number is %d.", array1[0]);
        } else if(array2[0] > array1[0]){
            System.out.println(array2);
            System.out.printf("The bigger number is %d.%d.%d", array2[0],array2[1],array2[2]);
        } else {
            if(array1[1] > array2[1]){
                System.out.println(array1);
                System.out.printf("The bigger number is %d.%d.%d", array1[0],array1[1],array1[2]);
            } else if(array2[1] > array1[1]){
                System.out.println(array2);
                System.out.printf("The bigger number is %d.%d.%d", array2[0],array2[1],array2[2]);
            } else {
                if(array1[2] > array2[2]){
                    System.out.println(array1);
                    System.out.printf("The bigger number is %d.%d.%d", array1[0],array1[1],array1[2]);
                } else if (array2[2] > array2[2]) {
                    System.out.println(array2);
                    System.out.printf("The bigger number is %d.%d.%d", array2[0],array2[1],array2[2]);
                } else {
                    System.out.print("They are the same.");
                }
            }
        }
       
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ComparingNums comparingNums = new ComparingNums();
        System.out.print("Enter a string of numbers: ");
        String number1 = in.nextLine();
        String result = number1.replaceAll("[^\\sa-zA-Z0-9]", "");
        System.out.println("TEST " + result);

        int array1[] = new int[result.length()];
        for(int i = 0; i < result.length(); i++){
        array1[i] = Integer.valueOf(result.substring(i));
        }

        System.out.println("Enter another string of numbers: ");
        String number2 = in.nextLine();
        String result2 = number2.replaceAll("[^\\sa-zA-Z0-9]", "");

        int array2[] = new int[result2.length()];
        for(int i = 0; i < result2.length(); i++){
        array2[i] = Integer.valueOf(result2.substring(i));
        }

        ComparingNums.whoIfFirst(array1, array2);
        

    }
}