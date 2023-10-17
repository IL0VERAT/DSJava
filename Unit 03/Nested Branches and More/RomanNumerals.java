import java.util.Scanner;
public class RomanNumerals {
    public static void main(String[]args)throws Exception{
        Scanner in = new Scanner(System.in);
        int number;
        System.out.print("Enter a positive integer from 1 to 3999: ");
        if(in.hasNextInt()){
            number = in.nextInt();

        }else{
            System.out.print("Error: You must have an integer value!");
            number = 0;
        }
        if(number < 0){
            System.out.print("Error: You cannot enter a negative value!");
            number = 0;
        }
        int ones = number % 10;
        int tens = (number % 100) - ones;
        int hundreds = (number % 1000) - (tens + ones);
        int thousands = (number % 10000) - (hundreds + tens + ones);

        String output_ones = switch(ones){
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
        String output_tens = switch(tens/10){
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
        String output_hundreds = switch(hundreds/100){
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
        String output_thousands = switch(thousands/1000){
            case 1 -> "M";
            case 2 -> "MM";
            case 3 -> "MMM";
            
            default -> "";
        };
        if (number ==0){
            System.out.printf("");
        }else{
            System.out.printf("Number equals %s%s%s%s%n",output_thousands, output_hundreds, output_tens, output_ones);
        }
        
        
        
    }
}
