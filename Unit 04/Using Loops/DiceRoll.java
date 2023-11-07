//Coder: Milo Linn-Boggs
import java.util.Scanner;
class Dice {
    int random; // represents the random number
    int max = 6; //sets the highest random number
    int min = 1; //sets the lowest random number
    

    public void Roll(){ //represents the roll of a die
            random = (int)Math.floor(Math.random() * (max - min + 1) + min); //calculates the random numbe
            if(random == 1){ //lines 11-51: represent the different faces based off what the random number is 
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
        Dice dice = new Dice(); //creates new die
        System.out.print("How many times would you like to roll the die: "); //asks user how many time they would like to roll the die
        int input = in.nextInt();

        for(int i = 0; i < input; i++){ //runs program number of times specified by user
            dice.Roll();
            System.out.println("");
        }
    }
}


