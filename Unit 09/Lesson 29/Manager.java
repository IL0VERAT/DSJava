public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }
    
    public double getAnnualIncome(){
        return getSalary() + bonus;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.printf("  Bonus = $%,.2f%n", bonus);
    } 
}
