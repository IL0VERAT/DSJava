//Coder: Milo Linn-Boggs Date: 8 Nov. 2023
public class LoopEvenInt{
    public static void main(String[] args) {
        int sum = 0;
        for(int i = 2; i <= 100; i = i + 2){ //runs as long as i is less than or equal to 100
            sum = sum + i; //adds up the values
        }
        System.out.println(sum); //prints out the final value
    }
}