import java.util.Scanner;
public class Example{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       
        int values[] = new int[5];

        int indexLargest = 0;

        for(int i = 0; i < values.length; i++){
            System.out.print("Input an integer: ");
            values[i] = in.nextInt();

            //is it the largest?
            if(i == 0 || values[i] > values[indexLargest]){
                indexLargest = i;
            }
        }
            //after all data collections, PRINT!(mark the largest)
            for(int i = 0; i < values.length; i++){
                System.out.print(values[i]);
                if(i == indexLargest){
                    System.out.println(" <= largest");
                } else {
                    System.out.println();
                }
            }
        

    }
}