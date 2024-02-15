class Counter{
    private int count; //member variable --> can't access it, only stuff inside counter see it
    
    //private and public and modifiers
    public int getValue(){ //implicite argument
        return count;
    }

    //Declare method to increase the count on device by 1
    public void count(){
        if(count == 9999){
            count = 0;
        } else {
        count++;
        }
    }

    //Declare method to reset counter
    public void reset(){
        count = 0;
    }

}
public class Tally{
    public static void main(String[] args) {
        System.out.println("This is a tally counter");
        Counter myCounter = new Counter(); //counter of counter type using new operator and counter instructor
    }
}