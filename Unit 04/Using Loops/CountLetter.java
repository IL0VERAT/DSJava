import java.util.Scanner;
public class CountLetter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("This program will accept a phrase and tell the user the amount of times the letter e appears.");
        
        boolean breaker = true;
        int count = 0;
        
        System.out.print("Enter a phrase: ");
        String phrase = in.nextLine();
        
        for (int i = 0; i <= phrase.length() - 1;i++){
            if(phrase.charAt(i) == 'e'){
                count = count + 1;
                breaker = false;
            }
            
            if(breaker == true){
                System.out.println("There is no letter e in this word or phrase");
            }
        } 
        System.out.print("The number of times the letter e appeared was " + count);
    }
}
