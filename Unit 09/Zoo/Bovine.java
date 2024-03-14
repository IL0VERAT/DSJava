package Zoo;

public class Bovine extends Mammal { // a child of the Mammal class --> takes all public and protected methods and constructors
    private double hayConsumed;

    public Bovine(String name, double weight) {
        super(name, weight); //super refers to the super class --> invokes the constructor of mammal class
    }

    public void feedHay(double pounds) {
        hayConsumed = hayConsumed + pounds;
    }

    public double getHayConsumed() {
        return hayConsumed;
    }

    public void printName(){
        System.out.println(this.getName()); // to print the private variable Name --> or change Name to public
    }
}
    

