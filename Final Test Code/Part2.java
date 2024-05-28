//Milo Linn-Boggs
public class Part2 {
    public static void main(String[] args) {
        String phrase = "Derryfield";

        for(int i = 0; i < phrase.length(); i++){
            System.out.print(phrase.substring(i, i+1));
            System.out.print(" | ");
        }
        System.out.println("");
        System.out.print("is the best!");
    }
}
