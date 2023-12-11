import java.util.Scanner;
public class ComparingNums2 {
    public static int I;
    public static String truncator;
    public static int leadingNumber(String section){
        I = section.indexOf(".");
        String nString = section.substring(0, I);
        int n = Integer.valueOf(nString);
        return n;
    }
    public static String truncateSection(String section){
        truncator = section.substring(I+1);
        return truncator;
    }
    public static void whoIsFirst(String section1, String section2){
        int leadWork1 = ComparingNums2.leadingNumber(section1);
        int leadWork2 = ComparingNums2.leadingNumber(section2);
        String truncateWork1 = ComparingNums2.truncateSection(section1);
        String truncateWork2 = ComparingNums2.truncateSection(section2);
        boolean breaker = true;

    while(breaker == true){
        if(leadWork1 == leadWork2){
            System.out.print("They are the same.");
            breaker = false;
        }
        if(leadWork1 > leadWork2){
            System.out.print(section1 +" is the bigger number.");
            breaker = false;
        } else if(leadWork2 > leadWork1){
            System.out.print(section2 +" is the bigger number.");
            breaker = false;
        } else {
            leadWork1 = ComparingNums2.leadingNumber(truncateWork1);
            leadWork2 = ComparingNums2.leadingNumber(truncateWork2);
        }
    }

    
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        String section1 = in.nextLine();
        System.out.print("Enter another  number: ");
        String section2 = in.nextLine();

        ComparingNums2.whoIsFirst(section1, section2);
    }
}
