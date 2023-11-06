class Dice {
    int random;
    int max = 6;
    int min = 1;
    boolean breaker = false;
    public void Roll(){
        while (breaker == false){
            random = (int)Math.floor(Math.random() * (max - min + 1) + min);
            breaker = true;
            System.out.printf("---%n|%1d%n---",random);
        }
    }
        
}
public class DiceRoll{
    public static void main(String[] args) {
        Dice dice = new Dice();
        dice.Roll();
    }
}

