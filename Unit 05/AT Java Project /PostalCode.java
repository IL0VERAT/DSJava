import java.util.Scanner;
public class PostalCode{
    static String[]codes;
    public static String[]getEncodedDigit(int d){
        int[]zipArray = new int[5];
        zipArray[4] = d%10;
        zipArray[3] = d%100/10;
        zipArray[2] = d%1000/100;
        zipArray[1]= d%10000/1000;
        zipArray[0] = d%100000/10000;
        String[]codes = new String[5];
        for(int i = 0; i < zipArray.length; i++){
        codes[i] = switch(zipArray[i]){
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
        }      
        return codes;
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
        System.out.print(codes);
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