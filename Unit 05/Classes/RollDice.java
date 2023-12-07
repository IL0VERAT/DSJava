//Coder: Milo Linn-Boggs Date: 7 Dec. 2023
import java.util.Scanner;
class Die{
    //member variables
    private int value; // the value of the die that's is facing up
    private int min = 1; //minimum value for the die value
    private int max = 6; //maximum value for the die value

    //constructor for setting initial amount (overloaded)
    public Die(int initialVal){
        //set value of die
        this.value = initialVal;

        setValue(initialVal);
    }

    //constructor for setting initial amount (no arguments)
    public Die(){
        this.value = 1; 
    }

    //setter method: ensures the users inputted data is within the parameters
    public void setValue(int newValue){
        // the only valid values range from 1 to 6
        if(newValue > 0 && newValue < 7){
            System.out.println("Heres the die with arguments");
        value = newValue;
        // if invalid value, prints error message
        } else {
            System.out.println("ERROR: INPUT NUMBER BETWEEN 1 AND 6");
        }
    }

    //roll method: randomizes the die
    public void Roll(){
        value = (int)Math.floor(Math.random() * (max - min + 1) + min);

    }

    //displays the die
    public void display(){
        if(value == 1){  
                System.out.printf("-----%n" + 
                        "|   |%n" + 
                        "| o |%n" + 
                        "|   |%n" + 
                        "-----");
            }
            if(value == 2){
                System.out.printf("-----%n" + 
                        "|o  |%n" + 
                        "|   |%n" + 
                        "|  o|%n" + 
                        "-----");
            }
            if(value == 3){
                System.out.printf("-----%n" + 
                        "|o  |%n" + 
                        "| o |%n" + 
                        "|  o|%n" + 
                        "-----");
            }
            if(value == 4){
                System.out.printf("-----%n" + 
                        "|o o|%n" + 
                        "|   |%n" + 
                        "|o o|%n" + 
                        "-----");
            }
            if(value == 5){
                System.out.printf("-----%n" + 
                        "|o o|%n" + 
                        "| o |%n" + 
                        "|o o|%n" + 
                        "-----");
            }
            if(value == 6){
                System.out.printf("-----%n" + //
                        "|o o|%n" + //
                        "|o o|%n" + //
                        "|o o|%n" + //
                        "-----");
            
            }
        }
    }
public class RollDice{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //asks the user for the inital value of the die
        System.out.print("What should the inital value of the die be: ");
        int input = in.nextInt();
        
        //displays the inital die face
        Die die = new Die(input);
        die.display();
        
        //randomizes the die and rolls it 3 times
        for(int i = 0; i < 3; i++){
            die.Roll();
            System.out.printf("%nHeres the rolled die.");
            System.out.println("");
            die.display();
        }
    
        //creates a new die with no arguments and prints it
        Die die2 = new Die();
        System.out.println("");
        System.out.println("Here's the die with no arguments.");
        die2.display();
    }
}