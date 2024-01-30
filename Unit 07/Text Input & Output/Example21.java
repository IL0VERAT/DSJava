import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Example21 {
    public static void main(String[] args) throws FileNotFoundException {
    File inputFile = new File("Top5Population.txt"); //can use full name here
    Scanner in = new Scanner(inputFile);
    //process file line by line
    //loop where there is still a nexy line in the file. 
    while (in.hasNextLine()) {
        String line = in.nextLine();

        //declare an int to track where the first digit in the line appears
        int i = 0;

        //loop through each character until I find the first numerical digit
        while(Character.isDigit(line.charAt(i)) == false){
            //if NOT digit, skip over it 
            i++;
        }

        String name = line.substring(0, i);
        
        //remove leading or following spaces
        name = name.trim();

        String result = line.substring(i);
        result = result.trim();

        int population = Integer.valueOf(result);

        System.out.printf("%s : %,20d %n", name, population);
    }
    in.close();
    }
}
