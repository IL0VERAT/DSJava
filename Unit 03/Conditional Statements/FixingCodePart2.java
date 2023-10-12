//Coder: Unknown Date: 11 October 2023
public class FixingCodePart2 {
    public static void main (String[]args) throws Exception{
        final double THRESHOLD = 1e-14; //Sets a threshold value (a very small number) to compare doubles 
        double a = 1.2; 
        double b= 3.0;
        double c = a * b; 
        if(Math.abs(c - 3.6) < THRESHOLD){ //Sees if the difference is less than the threshold number
        System.out.println("c is 3.6"); //If so, prints this statement
        } else {
        System.out.println("c is not 3.6"); //If not, prints this other statment
        }
    }
}
