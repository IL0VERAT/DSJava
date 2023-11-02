import java.util.Scanner;
public class CountWord{
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        //prompts user for phrase
        System.out.print("Enter a phrase (type q to quit): ");
        final String TARGET_PHRASE = "the";
        String word;
        int count = 0;
        boolean breaker;
        for (in.hasNext()){
            //get next word.
            word = in.next();
            breaker = false;
            //do they want to quit?
            if(breaker = true){
                break;
            }
            System.out.printf("%nword = %s", word);

            if(word.equals (TARGET_PHRASE)){
                count = count + 1;
            }
        } while (in.hasNext())
        System.out.printf("%nThe word %s appears %d times.", TARGET_PHRASE, count);
        
    }
}