import java.util.Arrays;
public class Example1{
    
    public static void squares(double[] values){
        for (int i = 0; i < values.length; i++){
            values[i] = values[i] * values[i];
        }
    }
    public static void main(String[] args) {
        double[] values = {2,4,6};
        Example1.squares(values);
        System.out.println(Arrays.toString(values));
    }
}