//Coder: Milo Linn-Boggs Date: 17 October 2023
import java.util.Scanner;
public class RomanNumerals {
    public static void main(String[]args)throws Exception{
        Scanner in = new Scanner(System.in);
        int number;
        System.out.print("Enter a positive integer from 1 to 3999: "); //asks user for a positive interger between 1 and 3999
        if(in.hasNextInt()){ //checks to see that the number given is an integer 
            number = in.nextInt(); //if given number is an interger, assigns it to var. number

        }else{
            System.out.print("Error: You must have an integer value!"); //if given number is NOT and integer, prints error statement
            number = 0; //sets number to 0
        }
        if(number < 0){ //checks to see if the given number is positive
            System.out.print("Error: You cannot enter a negative value!"); //if given numer is NOT positive, then prints errors statement
            number = 0; //sets number to 0
        }
        int ones = number % 10; //calculates whats in the ones column
        int tens = (number % 100) - ones; //whats in the tens column
        int hundreds = (number % 1000) - (tens + ones); //whats in the hundreds column
        int thousands = (number % 10000) - (hundreds + tens + ones); //whats in the thousands column

        String output_ones = switch(ones){ //determines, depending on the input, which roman numeral represents the ones
            case 1 -> "I";
            case 2 -> "II";
            case 3 -> "III";
            case 4 -> "IV";
            case 5 -> "V";
            case 6 -> "VI";
            case 7 -> "VII";
            case 8 -> "VIII";
            case 9 -> "IX";
            
            default -> "";
        };
        String output_tens = switch(tens/10){ //determines, depending on the input, which roman numeral represents the tens
            case 1 -> "X";
            case 2 -> "XX";
            case 3 -> "XXX";
            case 4 -> "XL";
            case 5 -> "L";
            case 6 -> "LX";
            case 7 -> "LXX";
            case 8 -> "LXXX";
            case 9 -> "XC";

            default -> "";
        };
        String output_hundreds = switch(hundreds/100){ //determines, depending on the input, which roman numeral represents the hundreds
            case 1 -> "C";
            case 2 -> "CC";
            case 3 -> "CCC";
            case 4 -> "CD";
            case 5 -> "D";
            case 6 -> "DC";
            case 7 -> "DCC";
            case 8 -> "DCCC";
            case 9 -> "CM";
            
            default -> "";
        };
        String output_thousands = switch(thousands/1000){ //determines, depending on the input, which roman numeral represents the thousands
            case 1 -> "M";
            case 2 -> "MM";
            case 3 -> "MMM";
            
            default -> "";
        };
        if (number ==0){ //checks to see if any error statement where triggered. If so, prints nothing
            System.out.printf("");
        }else{ //if no errors, prints the roman numeral 
            System.out.printf("Number equals %s%s%s%s%n",output_thousands, output_hundreds, output_tens, output_ones);
        }
        
        
        
    }
}
