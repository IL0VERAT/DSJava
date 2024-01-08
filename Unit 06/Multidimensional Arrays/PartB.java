//Coder: Milo Linn-Boggs Date: 8 Jan. 2024
public class PartB {

    //method to print out arrays with commas
    public static void print(int[][] chart){
        for (int row = 0; row < chart.length; row++) {
            for (int col = 0; col < chart[0].length; col++) {
                System.out.print(chart[row][col]);
                // only print a comma if it's not the last column.
                if (col < chart[0].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        //first array is initialized and sent through the custom method
        int arrayOne[][] = {
            {8, 6, 7},
            {5, 3, 0}
        };
        System.out.println("First Array: ");
        PartB.print(arrayOne);

         //second array is initialized and sent through the custom method
        int arrayTwo[][] = {
            {0, 7, 6, 5},
            {2, 2, 0, 1},
            {8, 4, 5, 7}
        };
        System.out.println("");
        System.out.println("Second Array: ");
        PartB.print(arrayTwo);
    }
}
