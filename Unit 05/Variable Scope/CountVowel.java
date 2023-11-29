//Coder: Milo Linn-Boggs Date: 29 Nov. 2023
import java.util.Scanner;
public class CountVowel {
    public static boolean isVowel(char c){ //helper method
        if (c == 'a'||c == 'e'||c == 'i'||c == 'o'||c == 'u'){ //checks to see if the character is a vowel
            return true; //returns true if a vowel
        } else {
            return false; //returns false if not a vowel
        }
    }
    public static int countVowel(String phrase){ 
        int count = 0; //creates a integer to manage count
        int l = phrase.length(); //gets the length of the users phrase and assigns it to l

        for (int i = 0; i < l; i++){ //loop to check if the character is a vowel
            if (isVowel(phrase.toLowerCase().charAt(i))) {
                count++; //if it is a vowel, add 1 to count
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        System.out.print("Enter a phrase: "); //asks the user for a phrase
        String input_phrase = in.nextLine();

        int answer = countVowel(input_phrase); //uses a method to determine how many letters in that phrase are vowels
        System.out.println("Num of vowels = " + answer); //prints out the number of vowel
    }
}
