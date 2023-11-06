import java.util.Scanner;
public class RandomNumber {
    public static void main(String[] args) {
        int max = 10;
        int min = 1;
        int random;
        int random2;
        double count = 0;
        double count2 = 0;
        
        Scanner in = new Scanner(System.in);
        System.out.print("How many times would you like to run the loop? ");
        int numTimes = in.nextInt();


        for (int i = 1; i <= numTimes; i++){
            //Got help from the cite: https://www.educative.io/answers/how-to-generate-random-numbers-in-java. for line 7. 
            random = (int)(Math.random() * (max - min + 1) + min);
            count = random + count;
        }
        System.out.println("The average of 10 random integers is: " + (count/numTimes));

        for (int j = 1; j<= 1000; j++){
            //Got help from the cite: https://www.educative.io/answers/how-to-generate-random-numbers-in-java. for line 7. 
            random2 = (int)(Math.random() * (max - min + 1) + min);
            count2 = random2 + count2;
        }
        System.out.println("The average of 1000 random integers is: " + (count2/1000));
    }
}

