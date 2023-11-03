import java.util.Scanner;
public class CountLetter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("This program will accept a phrase and tell the user the amount of times the letter e appears.");

        final String TARGET_LETTER = "e";
        boolean breaker = true;
        int count = 0;
        System.out.print("Enter a phrase: ");
        String phrase = in.nextLine();
        String seperator;
        
        for (int i = 0; i < phrase.length();i++){
            seperator = phrase.charAt(i);
            if(seperator.equals (TARGET_LETTER)){
                count = count + 1;
            }
        } 
        System.out.print("The number of times the letter e appeared was " + count);
    }
}
