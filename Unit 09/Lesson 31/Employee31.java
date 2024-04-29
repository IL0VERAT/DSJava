public class Employee31 {
    private String name;
    private double salary;

    /*
     * Constructor.
     */
    public Employee31(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double newSalary) {
        salary = newSalary;
    }

    public double getAnnualIncome() {
        // Employees only get an annual salary.
        return getSalary();
    }

    public void displayInfo() {
        System.out.println(name + ":");
        System.out.printf("  Salary = $%,12.2f%n", salary);
    }

    //overide toString() method
    public String toString(){
        String val = this.getClass().getName() 
        + "[name = " + this.name 
        + ", salary = " + this.salary + "]";
        return val;

    }

    //overide equals() method
    public boolean equals(Object obj){
        if(obj.getClass() != this.getClass()){
            return false;
        } else {
            //cast the other object into Employee31 type
            Employee31 otherEmployee = (Employee31)obj;
            if(name.equals(otherEmployee.getName()) && Double.compare(salary, otherEmployee.getSalary()) == 0){
                return true;
            } else {
                return false;
            }
        }
    }
}