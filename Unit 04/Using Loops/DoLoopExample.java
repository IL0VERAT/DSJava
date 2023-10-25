import java.util.Scanner;
public class DoLoopExample{
    public static void main(String[]args){
        int row;
        int column;
        int product;
        for(row = 1; row <= 5; row++){
            for(column = 1; column <= 5; column++){
                product = row * column;
            
                System.out.printf("%5d", product);
            }
        }
        
    }
}