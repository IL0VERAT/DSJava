import java.util.ArrayList;
public class Demo {
    public static void main(String[] args) {
        ArrayList<Measurable> animals = new ArrayList<>();
        animals.add(new Animal("Gerald", 1200));
        animals.add(new Animal("Claudette", 1000));
        animals.add(new Animal("Kathy", 1100));

        System.out.println("The average weight of the animals is " + Measurable.calcAvg(animals));

        ArrayList<Measurable> accounts = new ArrayList<>();
        accounts.add(new BankAccount(1, 1000));
        accounts.add(new BankAccount(2, 100));
        accounts.add(new BankAccount(3, 100));

        System.out.println("The average balance of the accounts are " + Measurable.calcAvg(accounts));
    }
}
