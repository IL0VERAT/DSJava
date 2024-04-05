//Coder: Milo Linn-Boggs Date: 04 April 2024
public class JobShowcase {
    public static void main(String[] args) {
        //create new examples of employee and manager class
        Employee e = new Employee("Gerald", 100000);
        Manager m = new Manager("Barbara", 100000,10000);

        //get annual income of employee
        System.out.println(e.getName() + " has a annual income of $" + e.getAnnualIncome());
        //get annual income of manager
        System.out.println(m.getName() + " has a annual income of $" + m.getAnnualIncome());

    }
}
