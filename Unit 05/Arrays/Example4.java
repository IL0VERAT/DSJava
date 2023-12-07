public class Example4 {
    public static void main(String[] args) {
        double[] numbers = {8,6,7,5,3,0,9};
        double counter = 0;

        for(double element:numbers){
            //counter = counter + element: equivalent to the +=
            counter += element;
            System.out.println(element);
        }
        System.out.println(counter/numbers.length);
    }
}
