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
        int work1 = ComparingNums2.leadingNumber(section1);
        int work2 = ComparingNums2.leadingNumber(section2);
        ComparingNums2.truncateSection(section2);

        if(work1 > work2){
            System.out.print(section1 +" is the bigger number");
        } else if(work2 > work1){
            System.out.print(section2 +" is the bigger number");
        } else {
            
        }

    
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        String section1 = in.nextLine();
        System.out.print("Enter another  number: ");
        String section2 = in.nextLine();
    }
}
