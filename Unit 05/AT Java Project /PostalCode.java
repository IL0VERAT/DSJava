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
        int sum,digit,number = 0;
        int workingNum = zipcode;
        while(workingNum > 0){
            
        }
    }
    public static void main(String[]args){

    }
}