public class RandomNumber {
    public static void main(String[] args) {
        int max = 10;
        int min = 1;
        int random;
        int count = 0;
        for (int i = 1; i <= 10; i++){
            //Got help from the cite: https://www.educative.io/answers/how-to-generate-random-numbers-in-java. for line 7. 
            random = (int)Math.floor(Math.random() * (max - min + 1) + min);
            count = random + count;
        }
        System.out.println(count);

        //for (int j = 1; j<= 1000; j++){
            //Got help from the cite: https://www.educative.io/answers/how-to-generate-random-numbers-in-java. for line 7. 
            //int random2 = (int)Math.floor(Math.random() * (max - min + 1) + min);
            //System.out.println(random2);
        }
    }

