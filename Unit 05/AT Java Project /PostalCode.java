//Coder: Milo Linn-Boggs Date: 10 Dec. 2023
import java.util.Scanner;
public class PostalCode{
    public static int checkDigit;
    //method to transform the zipcode into the encoded bars
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

    //method to get the check digit so the total is a multiple of 10
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
        //citation: https://www.geeksforgeeks.org/round-the-given-number-to-nearest-multiple-of-10/
        int answer = (sum - a > b - sum)? b : a;
        
        //ensure the code still works if the inputted zipcode is less than 10
        if(sum%10 < 5){
            sum = Math.abs(10 - sum);
            checkDigit = Math.abs(answer - sum);
        } else {
            checkDigit = Math.abs(answer-sum);
        }   
    }

    //method to print the barcode
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
        Scanner in = new Scanner (System.in);

        //asks the user for the zipcode
        System.out.print("Enter a zipcode: ");

        //assigns the users input to the methods inputs
        int zip = in.nextInt();

        //runs the methods
        PostalCode.getCheckDigit(zip);
        PostalCode.getEncodedDigit(zip);
        PostalCode.printBarCode(zip);
    }
}