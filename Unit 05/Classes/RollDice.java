import java.util.Scanner;
class Die{
    //member variables
    private int value; // the value of the die that's is facing up
    private int numTimes;
    private int max = 6; 
    private int min = 1;
    private int randomVal;

    //constructor for setting initial amount
    public Die(int initialVal){
        //set value of die
        this.value = initialVal;
    }

    public Die(){
        this.numTimes = 6; 
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
    public void display(){
        System.out.println("The inital values was "+ value);
        value  = randomVal;
        randomVal = (int)Math.floor(Math.random() * (max - min + 1) + min);
        if(randomVal == 1){  
                System.out.printf("-----%n" + 
                        "|   |%n" + 
                        "| o |%n" + 
                        "|   |%n" + 
                        "-----");
            }
            if(randomVal == 2){
                System.out.printf("-----%n" + 
                        "|o  |%n" + 
                        "|   |%n" + 
                        "|  o|%n" + 
                        "-----");
            }
            if(randomVal == 3){
                System.out.printf("-----%n" + 
                        "|o  |%n" + 
                        "| o |%n" + 
                        "|  o|%n" + 
                        "-----");
            }
            if(randomVal == 4){
                System.out.printf("-----%n" + 
                        "|o o|%n" + 
                        "|   |%n" + 
                        "|o o|%n" + 
                        "-----");
            }
            if(randomVal == 5){
                System.out.printf("-----%n" + 
                        "|o o|%n" + 
                        "| o |%n" + 
                        "|o o|%n" + 
                        "-----");
            }
            if(randomVal == 6){
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
        die.display();
    }
}