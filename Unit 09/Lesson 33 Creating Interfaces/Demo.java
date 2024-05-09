import java.util.ArrayList;
public class Demo {
    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Gerald", 1200));
        animals.add(new Animal("Claudette", 1000));
        animals.add(new Animal("Kathy", 1100));

        System.out.println(Animal.calcAvg(animals));
    }
}
