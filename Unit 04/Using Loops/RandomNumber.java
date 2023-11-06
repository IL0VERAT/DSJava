import java.util.Scanner;
public class RandomNumber {
    public static void main(String[] args) {
        int max = 10; //sets the highest value the number could be
        int min = 1; //sets the lowest value the number could be
        int random; //sets an integer for the random number
        double count = 0; //adds up all the numbers to eventually average it out
        
        Scanner in = new Scanner(System.in); //asks user for how many times one wants to run the program
        System.out.print("How many times would you like to run the loop? ");
        int numTimes = in.nextInt();


        for (int i = 1; i <= numTimes; i++){ //runs the loop for however many times inputted by user
            //Got help from the cite: https://www.educative.io/answers/how-to-generate-random-numbers-in-java. for line 7. 
            random = (int)(Math.random() * (max - min + 1) + min); //generates the random values
            count = random + count; //adds the numbers together to average out
        }
        System.out.printf("The average of 10 random integers is: %.2f ", (count/numTimes)); //prints out the averaged value

        /*Reasoning: If one runs the loop only 10 times, the chance of any number appearing is 1 out of 10. 
        Thus, their is supposedly an equal chance to get any number from 1 to 10. This means that the average number that one will get is 5.5. 
        Furthermore, the more random numbers in putted into the system, the closer the average will be to 5.5. */
    }
}

