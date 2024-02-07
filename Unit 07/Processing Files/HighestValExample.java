import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class HighestValExample {
   public static void main(String[] args) throws FileNotFoundException {
       // create a File object to use as our input file.
       File inputFile = new File("Example.txt");


       // open the file for reading as a Scanner object.
       // make sure our main method throws FileNotFoundException.
       Scanner in = new Scanner(inputFile);


       // create an array list of Integer type to hold data.
       ArrayList<Integer> values = new ArrayList<>();


       // declare a variable to track the highest valiue.
       // initialize this variable to the lowest possible value.
       int highest = Integer.MIN_VALUE;


       // we can use the standard delimiters for the Scanner object.
       // loop while there is data for us to process.
       while (in.hasNext()) {
           // we assume there are only integer values in the file
           // so we don't do rigorous data checking here.
           // scan in the next value from the file.
           int value = in.nextInt();


           // add the value to the ArrayList.
           values.add(value);


           // check if we have a new highest value.
           if (value > highest) {
               highest = value;
           }
       }


       // open a file for writing.
       File outputFile = new File("out_A.txt");
       PrintWriter out = new PrintWriter(outputFile);


       // loop through the array list and write to file.
       for (int i = 0; i < values.size(); i++) {
           out.printf("value #%03d: %4d", i, values.get(i));


           // if this is the highest value, mark it as such.
           if (values.get(i) == highest) {
               out.print(" <== highest");
           }


           // print a newline.
           out.println();
       }


       // close the input and output files.
       in.close();
       out.close();
   }
}

