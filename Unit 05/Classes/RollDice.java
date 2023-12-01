class Die{
    //member variables
    private int value; // the value of the die that's is facing up

    //constructors
    public Die(){
        //set value of die to be 1
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
}
public class RollDice{
    public static void main(String[] args) {
        Die die = new Die();
        System.out.println(die.getValue());
        //change value 
        die.setValue(5);
        System.out.print(die.getValue());
    }
}