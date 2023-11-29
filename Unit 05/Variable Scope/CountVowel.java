import java.util.Scanner;
public class CountVowel {
    public static boolean isVowel(char c){
        if (c == 'a'||c == 'e'||c == 'i'||c == 'o'||c == 'u'){
            return true;
        } else {
            return false;
        }
    }
    public static int countVowel(String phrase){
        int count = 0;
        int l = phrase.length();

        for (int i = 0; i < l; i++){
            if (isVowel(phrase.toLowerCase().charAt(i))) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        System.out.print("Enter a phrase: ");
        String input_phrase = in.nextLine();

        int answer = countVowel(input_phrase);
        System.out.println("num of vowels = " + answer);
    }
}
