//Coder: Milo Linn-Boggs Date: 3 Nov. 2023
import java.util.Scanner;
public class CountLetter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //tells user how to use program
        System.out.println("This program will accept a phrase and tell the user the amount of times the letter e appears.");
        
        //creates an integer to represent the amount of times e appears in the inputted phrase
        int count = 0;
        
        //prompts user to enter a phrase
        System.out.print("Enter a phrase: ");
        String phrase = in.nextLine();
        
        //loop: for as long as i is less than or equal to the inputted phrase, loop runs and i increases
        for (int i = 0; i <= phrase.length() - 1;i++){
            //checks to see if i is the letter e
            if(phrase.charAt(i) == 'e'){
                //if true, then adds one to count
                count = count + 1;
            }
        } 
        //prints out the number of e's in the phrase
        System.out.print("The number of times the letter e appeared was " + count);
    }
}
