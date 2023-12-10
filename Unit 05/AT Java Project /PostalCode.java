import java.util.Scanner;
public class PostalCode{
    public static int checkDigit;
    public static String getEncodedDigit(int input){
        String codes = switch(input){
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
        return codes;
    }

    public static void getCheckDigit(int zipcode){
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
        
        if(sum%10 < 5){
            sum = Math.abs(10 - sum);
            checkDigit = Math.abs(answer - sum);
        } else {
            checkDigit = Math.abs(answer-sum);
        }   
    }
    public static void printBarCode(int d){
        String ends = "|";
        String printed = "";
        int[]zipArray = new int[5];
        zipArray[4] = d%10;
        zipArray[3] = d%100/10;
        zipArray[2] = d%1000/100;
        zipArray[1]= d%10000/1000;
        zipArray[0] = d%100000/10000;
        for(int i = 0; i < 5; i++){
            printed = printed + getEncodedDigit(zipArray[i]);
        }
        System.out.print(ends + printed + getEncodedDigit(checkDigit) + ends);
    }
    public static void main(String[]args){
        PostalCode postalcode = new PostalCode();
        Scanner in = new Scanner (System.in);
        System.out.print("Enter a zipcode: ");
        int zip = in.nextInt();
        PostalCode.getCheckDigit(zip);
        PostalCode.getEncodedDigit(zip);
        PostalCode.printBarCode(zip);

    }
}