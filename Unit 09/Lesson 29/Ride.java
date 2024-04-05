//Coder: Milo Linn-Boggs Date: 04 April 2024
public class Ride {
    public static void main(String[] args) {

        //example of parent class bicycle
        Bicycle b = new Bicycle();
        System.out.println("Standard Bicycle");
        b.pedal();
        b.pedal();
        b.display();
        System.out.println("");

        //example of geared bicycle class with overridden breaking method 
        GearedBicycle gb = new GearedBicycle();
        System.out.println("Geared Bicycle:");
        gb.pedal();
        gb.display();
        gb.shiftUp();
        gb.shiftUp();
        gb.pedal();
        gb.display();
        gb.brake();
        gb.display();
    }
}
