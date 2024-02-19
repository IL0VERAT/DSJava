//Coder: Milo Linn-Boggs Date: 19 Feb. 2024
import java.util.Scanner;

//custom class
class Counter{
    private int count; 
    
    public int getValue(){ 
        return count;
    }

    public void count(){
        if(count < 9999){
            count++;
        } else {
        count = 0;
        }
    }

    public void reset(){
        count = 0;
    }

}
public class PartB{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Counter myCounterCake = new Counter(); 
        Counter myCounterPie = new Counter(); 

        //loop to check for votes
        while(true){
        System.out.println("Enter p to vote for pie or c to vote for cake. Or enter q to quit: ");

        if(in.hasNext("q")||in.hasNext("Q")){
            in.next();
            break;
        } else if(in.hasNext("c")||in.hasNext("C")){
            in.next();
            myCounterCake.count();
        } else if(in.hasNext("p")||in.hasNext("P")){
            in.next();
            myCounterPie.count();
        } else {
            System.out.println("Invalid input");
            in.next();
        }
        }

        //prints results
        System.out.println("Cake got " + myCounterCake.getValue() + " votes");
        System.out.println("Pie got " + myCounterPie.getValue() + " votes");



    }
}
