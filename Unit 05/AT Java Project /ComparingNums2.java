import java.util.Scanner;
public class ComparingNums2 {
    public static int I;
    public static int leadingNumber(String section){
        I = section.indexOf(".");
        String nString = section.substring(0, I);
        int n = Integer.valueOf(nString);
        return n;
    }

    public static String truncateSection(String section){
        String truncator = section.substring(I);
        
    }
    public static void whoIsFirst(String section1, String section2){

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String section1 = in.nextLine();

        System.out.print("Enter another  number: ");
        String section2 = in.nextLine();
    }
}
