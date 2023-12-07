import java.util.Scanner;
public class ComparingNums{
    public static int leadingNumber(String section){
        String truncate = section.substring(0);
        int integerTruncate = Integer.parseInt(truncate);
        return integerTruncate;
    }
    public static int truncateSection(String section){
        String lastPartTruncate = section.substring(2,5);
        int integerPartTruncate = Integer.parseInt(lastPartTruncate);
        return integerPartTruncate;

    }
    public static String whoIfFirst(String section1, String section2){
        String work1 = section1;
        String work2 = section2;
        int n1 = 0;
        int n2 = 0;

        String result; 
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a string of numbers: ");
        String number1 = in.nextLine();
        System.out.println("Enter another string of numbers: ");
        String number2 = in.nextLine();

        number1 = leadingNumber(number1);

    }
}