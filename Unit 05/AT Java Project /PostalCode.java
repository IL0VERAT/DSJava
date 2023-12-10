import java.util.Scanner;
public class PostalCode{
    static String barTransformer;
    public static String getEncodedDigit(int d){
        int ones = d%10;
        int tens = d%100 - ones;
        int hundreds = d%1000 - tens - ones;
        int thousands = d%10000 - hundreds-tens-ones;
        int ten_thousands = d%100000 - thousands-hundreds-tens-ones;
        int[]zipArray = {ten_thousands,thousands,hundreds,tens,ones};
        barTransformer = switch(d) {
            case 1 -> ":::||";
            case 2 -> "::|:|";
            case 3 -> "::||:";
            case 4 -> ":|::|";
            case 5 -> ":|:|:";
            case 6 -> ":||::";
            case 7 -> "|:::|";
            case 8 -> "|::|:";
            case 9 -> "|:|::";
            case 0 -> "||:::";

            default -> "ERROR";
            };        
        return barTransformer;
    }

    public static int getCheckDigit(int zipcode){
        int sum = 0;
        int digit = 0;
        int workingNum = zipcode;
        while(workingNum > 0){
            digit = workingNum%10;
            sum = sum + digit;
            workingNum = workingNum/10;
        }

        int a = (sum / 10) * 10; 
        int b = a + 10;
        int answer = (sum - a > b - sum)? b : a;
        
        int checkDigit; 
        if(answer < 4){
            sum = 10 - sum;
            checkDigit = Math.abs(answer - sum);
        } else {
            checkDigit = Math.abs(answer-sum);
        }
        return answer;
    }
    public static void printBarCode(int zipCode){
        System.out.print(barTransformer);
    }
    public static void main(String[]args){
        PostalCode postalcode = new PostalCode();
        Scanner in = new Scanner (System.in);
        System.out.print("Enter a zipcode: ");
        int zip = in.nextInt();
        PostalCode.getEncodedDigit(zip);
        PostalCode.printBarCode(zip);

    }
}