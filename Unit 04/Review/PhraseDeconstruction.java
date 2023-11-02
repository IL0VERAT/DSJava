//Coder: Milo Linn-Boggs Date: 2 Nov. 2023
import java.util.Scanner;
public class PhraseDeconstruction {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        //asks user for a phrase
        System.out.print("Enter a phrase: ");
        String phrase = in.nextLine();
        //i represents the index that will be changed
        int i;
        //loop that runs through phrase 
        for (i = 0; i < phrase.length(); i = i + 2){
            //prints out the result
            System.out.print(phrase.charAt(i));
        }
        System.out.println();
    }
}
