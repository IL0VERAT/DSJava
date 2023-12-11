import java.util.Arrays;
public class TestArray{
    public static void main(String args[]){
        int[]orig = {7,3,2,5,1};
        System.out.println("original: " + Arrays.toString(orig));

        Arrays.sort(orig);
        System.out.println("sorted: " + Arrays.toString(orig));
    }
}