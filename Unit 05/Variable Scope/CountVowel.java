import java.util.Scanner;
public class CountVowel {
    static int count;
    static String mover_phrase;
    public static int isVowel(String mover_phrase){
        for (int i = 0; i <= mover_phrase.length();i++){
            char ch = mover_phrase.charAt(i);
            if(ch == 'a'|| ch == 'e'|| ch == 'i' ||ch == 'o' ||ch == 'u'||ch == ' '){
                count ++;
            }
        }
        return count;
    }
    public static int CountVowel(String phrase){
        phrase = mover_phrase;
        return count;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        System.out.print("Enter a phrase: ");
        String input_phrase = in.nextLine();

        int answer = isVowel(input_phrase);
        System.out.print(answer);


    }
}
