import java.util.Scanner;
public class ComparingNums2 {
    public static String truncator;
    public static int leadingNumber(String section){
        int i;
        int n = 0;
        i = section.indexOf(".");
        if (i >= 0){
        String nString = section.substring(0, i);
        n = Integer.valueOf(nString);
        } else {
        n = Integer.valueOf(section);
        }
        return n;
    }
    public static String truncateSection(String section){
        int i = section.indexOf(".");
        if(i >= 0){
        truncator = section.substring(i+1);
        } else {
            truncator = "";
        }
        return truncator;
    }
    public static void whoIsFirst(String section1, String section2){
        int i;
        String truncateWork1 = section1;
        String truncateWork2 = section2;
        boolean breaker = true;

    while(breaker == true){
        if(truncateWork1.length() == 0){
            System.out.print(section2 + "is bigger");
            breaker = false;
        } else if(truncateWork2.length() == 0){
            System.out.print(section1 + "is bigger");
            breaker = false;
        }
    
        int leadWork1 = ComparingNums2.leadingNumber(truncateWork1);
        int leadWork2 = ComparingNums2.leadingNumber(truncateWork2);
        truncateWork1 = ComparingNums2.truncateSection(truncateWork1);
        truncateWork2 = ComparingNums2.truncateSection(truncateWork2);

        if(leadWork1 > leadWork2){
            System.out.print(section1 +" is the bigger number.");
            breaker = false;
        } else if(leadWork2 > leadWork1){
            System.out.print(section2 +" is the bigger number.");
            breaker = false;
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
