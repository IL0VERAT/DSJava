import java.util.Scanner;
import java.util.Arrays;
public class SearchComparison {
    public static void linearSearch(int[] array, int tgtVal){
        System.out.println("");
        System.out.println("LINEAR SEARCH: ");
        int searchedValue = tgtVal;
        int pos = 0;
        boolean found = false;
        long startLinear = System.currentTimeMillis(); 
        long endLinear; 
        while (pos < array.length && !found) {
            if (array[pos] == searchedValue) {
                endLinear =  System.currentTimeMillis() - startLinear;
                System.out.println("The number " + searchedValue + " was found in the array.");
                System.out.println("Time to find number: " + endLinear);
                System.out.println("");
                found = true;
            } else {
                pos++;
            }
        }
        if(found == false){
            System.out.println("Number not found in random array.");
            System.out.println("");
        }
    }

    public static void binarySearch(int[] array, int tgtVal){
        System.out.println("BINARY SEARCH: ");
        Arrays.sort(array);
        long startBinary = System.currentTimeMillis(); 
        long endBinary; 
        int index = Arrays.binarySearch(array, tgtVal);
        if (index >= 0) {
            endBinary = System.currentTimeMillis() - startBinary;
            System.out.println("BINARY: The number " + tgtVal + " was found in the array.");
            System.out.println("Time to find number: " + endBinary);
            System.out.println("");
        } else {
            System.out.println("Number not found in random array.");
            System.out.println("");
        }

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int numRandomNumbers = 10000000; //eventually switch to user input
        int max = numRandomNumbers;
        int min = 1;
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
