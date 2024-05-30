//Milo Linn-Boggs 30 May 2024
public class Demo {
    public static void main(String[] args) {

        //created two objects of animal type
        Animal gary = new Animal("Gary", 1000.0);
        Animal george = new Animal("George", 1100.0);

        //compares their weights using compareTo method
        if(gary.compareTo(george) == +1){
            System.out.println("Gary weighs more than George");
        } else if(gary.compareTo(george) == -1){
            System.out.println("George weighs more than Gary");
        } else {
            System.out.println("They weigh the same amount");
        }

        

    }
}
