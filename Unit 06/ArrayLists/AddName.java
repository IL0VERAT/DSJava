import java.util.ArrayList;
import java.util.Scanner;

public class AddName {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<String>();

        while (true) {
            System.out.println("Enter a name: ");

            if (in.hasNext("#")) {
                in.next();
                break;
            } else {
                names.add(in.nextLine());
            }
        }
        
        System.out.println("NAMES: ");
        for(int i = 0; i < names.size(); i++){
            System.out.println(names.get(i));
        }
    }
}
