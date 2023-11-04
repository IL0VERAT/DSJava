public class RandomNumber {
    public static void main(String[] args) {
        int max = 10;
        int min = 1;
        int random;
        int random2;
        int count = 0;
        int count2 = 0;
        for (int i = 1; i <= 10; i++){
            //Got help from the cite: https://www.educative.io/answers/how-to-generate-random-numbers-in-java. for line 7. 
            random = (int)Math.round(Math.random() * (max - min + 1) + min);
            count = random + count;
        }
        System.out.println("The average of 10 random integers is: " + (count/10));

        for (int j = 1; j<= 1000; j++){
            //Got help from the cite: https://www.educative.io/answers/how-to-generate-random-numbers-in-java. for line 7. 
            random2 = (int)Math.floor(Math.random() * (max - min + 1) + min);
            count2 = random2 + count2;
        }
        System.out.println("The average of 1000 random integers is: " + (count2/1000));
    }
}

