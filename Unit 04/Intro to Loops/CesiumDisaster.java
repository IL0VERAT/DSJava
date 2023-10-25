import java.util.Scanner;
public class CesiumDisaster{
    public static void main (String[]args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter amount of spilled cesium: ");
        double Cesium_Original = in.nextDouble();
        double Cesium_Math = Cesium_Original;
        int years = 0;
        while (Cesium_Math >= (0.01 * Cesium_Original)){
            Cesium_Math = Cesium_Math/2;
            years = years + 30;
        }
        System.out.print("The amount of years needed for cesium-90 to reach less than 99% of its original mass is " + years + " years.");
        
        System.out.println("  The amount of material left over is " + Cesium_Math);
        
    }
}