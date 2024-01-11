//Coder: Milo Linn-Boggs Date: 11 Jan. 2023
import java.util.ArrayList;
import java.util.Scanner;

public class AddName {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<String>();

        //asks the user to input names
        while (true) {
            System.out.println("Enter a name: ");

            //breaks code if # is inputted
            if (in.hasNext("#")) {
                in.next();
                break;
            } else {
                names.add(in.nextLine());
            }
        }
        
        //prints out the names in order
        System.out.println("NAMES: ");
        for(int i = 0; i < names.size(); i++){
            System.out.println(names.get(i));
        }
    }
}
