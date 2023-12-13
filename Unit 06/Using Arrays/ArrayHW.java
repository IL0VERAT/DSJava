
/*
HW Part A #1. 
Question: Given the declaration below, what is the value of array[3]?
                        int[] array = {4, 3, 5, 2, 0};

Answer: 2

HW Part A #2
Question: Given the declaration below, which of the following statements would cause a run-time error?
                        int[] array = {4, 3, 5, 2, 0};

Answer: array[5] = 1;

HW Part A #3
Question: Consider the following code segment. What is the value of b[2] after the code executes?
                        int[] a = { 0, 1, 2, 3, 4 };
                        int[] b = { 0, 1, 4, 9 };
                        a = b;
                        b = a;

Answer: 4
 */
//Coder: Milo Linn-Boggs Date: 12 Dec. 2023
public class ArrayHW{
    public static void main(String args[]){
        //creates array numbers with known values
        double numbers[] = {2.2, 1.0, 3.7, 4.1, 88.0 };
        //loops through length of array
        for(double element:numbers){
            //each time it prints out the array level
            System.out.println(element);
        }
    }
    
}
