public class NumberArranging {
    public static void main(String[] args) {
        final int LENGTH = 10;
        int[] random = new int[LENGTH];
        System.out.println("Original: ");
        for (int i = 0; i < LENGTH; i++) {
            random[i] = (int)(Math.random() * 100);
            System.out.print(random[i] + " ");
        }
        System.out.println(" ");

        System.out.println("Numbers At Even Indices: ");
        for(int i = 0; i < LENGTH; i += 2){
            System.out.print(random[i] + " ");
        }
        System.out.println(" ");

        System.out.println("Even Numbers Only: ");
        for(int i = 0; i < LENGTH; i++){
            if(random[i]%2 == 0){
                System.out.print(random[i] + " ");
            }
        }
        System.out.println(" ");

        System.out.println("Numbers In Reverse Order: ");
        for(int i = LENGTH - 1; i > -1; i--){
            System.out.print(random[i] + " ");
        }
        System.out.println(" ");

        System.out.println("First and Last Numbers: ");
        System.out.print(random[(LENGTH-1)-(LENGTH-1)] + " ");
        System.out.print(random[LENGTH-1] + " ");

    }
}