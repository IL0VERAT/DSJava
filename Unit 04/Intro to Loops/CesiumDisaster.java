//Coder: Milo Linn-Boggs Date: 24 October 2023
import java.util.Scanner;
public class CesiumDisaster{
    public static void main (String[]args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter numerial amount of spilled cesium-90: "); //asks user for amount of spilled cesium
        double cesium_Original = in.nextDouble(); //assigns input a value
        double cesium_Math = cesium_Original; //variable to be actually changing due to loop
        int years = 0; //number of years
        
        while (cesium_Math >= (0.01 * cesium_Original)){ //condition: while the modifiable variable is greater than 99% of the user input
            cesium_Math = cesium_Math/2; //while loop is active, takes the modeifiable variable and divides it by 2. 
            years = years + 30; //adds 30 years to the years variable every time loop happens
        }

        double percentageValue = (cesium_Math/cesium_Original) * 100; //calculates 
        System.out.print("The amount of years needed for cesium-90 to reach less than 99% of its original mass is " + years + " years."); //prints out the # of years taken to acheieve result
        
        System.out.println("   The amount of material left over is " + percentageValue + "% of the original value."); //prints out amount of cesium-90 left over
        
    }
}