import java.util.Scanner;
public class PartB {
    public static double smallest (double x, double y, double z){
        if(x < y){
            if(x < z){
                return x;
            }
        } 
        else if(y < z){
            return y;
        } 
        else if(z < y){
            if(z < x){
                return z;
            }
        }
        return z; }
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter three numbers: ");
            
            double a = in.nextDouble();
            double b = in.nextDouble();
            double c = in.nextDouble();

            double answer = smallest(a, b, c);

            System.out.println(answer);
    }
}
