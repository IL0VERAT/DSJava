//Coder: Milo Linn-Boggs Date: 01 October 2023//
import java.util.Scanner; //imports scanner class//
public class MonogramMachine {
    public static void main(String[]args) throws Exception {
        Scanner in = new Scanner(System.in);
        
        System.out.print("What is your first name? ");
        String first_full = in.nextLine(); //asks user for first name//

        System.out.print("What is your middle name? ");
        String middle_full = in.nextLine(); //asks user for middle name//

        System.out.print("What is your last name? ");
        String last_full = in.nextLine(); //asks user for last name//

        String first = first_full.substring(0, 1);//takes first letter of users responses and assigns it a variable//
        String middle = middle_full.substring(0, 1);
        String last = last_full.substring(0, 1);

        System.out.println("Your monogram is " +first+middle+last); //prints out the users monogram//
    }
}