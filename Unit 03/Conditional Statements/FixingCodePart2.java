public class FixingCodePart2 {
    public static void main (String[]args) throws Exception{
        final double THRESHOLD = 1e-235;
        double a = 1.2; 
        double b= 3.0;
        double c = a * b; 
        if(Math.abs(c - 3.6) < THRESHOLD){
        System.out.println("c is 3.6");
        } else {
        System.out.println("c is not 3.6");
        }
    }
}
