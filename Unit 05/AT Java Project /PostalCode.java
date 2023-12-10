import java.util.Scanner;
public class PostalCode{
    public static String getEncodedDigit(int d){
        String barTransformer = switch(d) {
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
            default -> "XXXXX";
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
        
        int checkDigit = Math.abs(answer - sum);

        System.out.print(checkDigit);
        return answer;
       
    }
    public static void main(String[]args){
        PostalCode postalcode = new PostalCode();
        Scanner in = new Scanner (System.in);
        System.out.print("Enter a zipcode: ");
        int zip = in.nextInt();
        PostalCode.getCheckDigit(zip);



    }
}