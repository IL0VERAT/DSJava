public class Lotteries{
    public static int main(String[]args){
        double luckeyNumber = 5.0;
        double randNum = Math.random();
        int count = 0;
        for(int i=0; i<100; i++){
            if (luckeyNumber == randNum*10){
                count++;
            }
        }
        
        return count;
    }
}