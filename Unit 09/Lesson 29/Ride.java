public class Ride {
    public static void main(String[] args) {
        Bicycle b = new Bicycle();
        b.pedal();
        b.pedal();

        GearedBicycle gb = new GearedBicycle();
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
