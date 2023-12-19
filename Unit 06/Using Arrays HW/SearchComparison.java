import java.util.Scanner;
import java.util.Arrays;
public class SearchComparison {
    public static void linearSearch(int[] array, int tgtVal){
        int searchedValue = tgtVal;
        int pos = 0;
        boolean found = false;
        long start = System.currentTimeMillis(); 
        while (pos < array.length && !found) {
            if (array[pos] == searchedValue) {
                System.out.print("The number " + searchedValue + " was found in the array.");
                found = true;
            } else {
                pos++;
            }
        }
    }

    public static void binarySearch(int[] array, int tgtVal){
        Arrays.sort(array);
        int index = Arrays.binarySearch(array, tgtVal);
        if (index >= 0) {
            System.out.println("The number " + tgtVal + " was found in the array.");
        }

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int max = 10000;
        int min = 1;
        final int numRandomNumbers = 10000; //eventually switch to user input
        int[]randArray = new int[numRandomNumbers];

        System.out.print("Enter a variable to search for: ");
        int userInput = in.nextInt();

        for (int i = 1; i < numRandomNumbers; i++){ 
            int random = (int)(Math.random() * (max - min + 1) + min); 
            randArray[i] = random; 
        }

        linearSearch(randArray, userInput);
        binarySearch(randArray, userInput);
    }
}
