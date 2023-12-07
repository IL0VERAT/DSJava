import java.util.Scanner;
class Die{
    //member variables
    private int value; // the value of the die that's is facing up
    private int min = 1; 
    private int max = 6;

    //constructor for setting initial amount
    public Die(int initialVal){
        //set value of die
        this.value = initialVal;

        setValue(initialVal);
    }

    public Die(){
        this.value = 1; 
    }
    //getter and setter method
    public int getValue(){
        return value;
    }

    public void setValue(int newValue){
        // the only valid values range from 1 to 6
        if(newValue > 0 && newValue < 7){
        value = newValue;
        }
    }
    public void Roll(){
        value = (int)Math.floor(Math.random() * (max - min + 1) + min);

    }
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
        System.out.print("What should the inital value of the die be: ");
        int input = in.nextInt();
        Die die = new Die(input);
        System.out.printf("%nHeres the die with arguments%n");
        die.display();
        for(int i = 0; i < 3; i++){
        die.Roll();
        System.out.printf("%nHeres the rolled die.");
        System.out.println("");
        die.display();
        System.out.println("");
        }
    
        Die die2 = new Die();
        System.out.println("");
        System.out.println("Here's the die with no arguments.");
        die2.display();
    }
}