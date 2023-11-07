import java.util.Scanner;
class Dice {
    int random;
    int max = 6;
    int min = 1;
    boolean breaker = false;
    

    public void Roll(){
            random = (int)Math.floor(Math.random() * (max - min + 1) + min);
            if(random == 1){
                System.out.printf("-----%n" + 
                        "|   |%n" + 
                        "| o |%n" + 
                        "|   |%n" + 
                        "-----");
            }
            if(random == 2){
                System.out.printf("-----%n" + 
                        "|o  |%n" + 
                        "|   |%n" + 
                        "|  o|%n" + 
                        "-----");
            }
            if(random == 3){
                System.out.printf("-----%n" + 
                        "|o  |%n" + 
                        "| o |%n" + 
                        "|  o|%n" + 
                        "-----");
            }
            if(random == 4){
                System.out.printf("-----%n" + 
                        "|o o|%n" + 
                        "|   |%n" + 
                        "|o o|%n" + 
                        "-----");
            }
            if(random == 5){
                System.out.printf("-----%n" + 
                        "|o o|%n" + 
                        "| o |%n" + 
                        "|o o|%n" + 
                        "-----");
            }
            if(random == 6){
                System.out.printf("-----%n" + //
                        "|o o|%n" + //
                        "|o o|%n" + //
                        "|o o|%n" + //
                        "-----");
            }
            
    }
}
        
public class DiceRoll{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Dice dice = new Dice();
        System.out.print("How many times would you like to roll the die: ");
        int input = in.nextInt();

        for(int i = 0; i < input; i++){
            dice.Roll();
            System.out.println("");
        }
    }
}


