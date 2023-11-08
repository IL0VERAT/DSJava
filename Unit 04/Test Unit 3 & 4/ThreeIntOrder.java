//Coder: Milo Linn-Boggs Date: 8 Nov. 2023
import java.util.Scanner;
public class ThreeIntOrder {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter three integers: "); //asks user for three integers

        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        int temp;

        if(n1 > n2){ //lines 14 to 46: checks to see arrangement of the inputted numbers, arranged them in increasing order if needed and prints them out
            temp = n1;
            n1 = n2;
            n2 = temp;
            if(n1 > n3){
                temp = n1;
                n1 = n3;
                n3 = temp;
                if(n2 > n3){
                    temp = n2;
                    n2 = n3;
                    n3 = temp;
                }
            }
            System.out.printf("%d,%d,%d",n1,n2,n3);
        } else if(n1 > n3){
            temp = n1;
                n1 = n3;
                n3 = temp;
                if(n2 > n3){
                    temp = n2;
                    n2 = n3;
                    n3 = temp;
                } 
                System.out.printf("%d,%d,%d",n1,n2,n3);
        } else if(n2 > n3){
            temp = n2;
            n2 = n3;
            n3 = temp;
            System.out.printf("%d,%d,%d",n1,n2,n3);
        } else{
        System.out.printf("%d,%d,%d",n1,n2,n3);
        }
    }
}

