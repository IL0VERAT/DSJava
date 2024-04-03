public class Ride {
    public static void main(String[] args) {
        Bicycle b = new Bicycle();
        System.out.printf("Speed = %02d%n", b.getSpeed());
        b.pedal();
        b.pedal();
        System.out.printf("Speed = %02d%n", b.getSpeed());

        GearedBicycle gb = new GearedBicycle();
        b.display();

        gb.shiftUp();
        gb.pedal();
        gb.pedal();
        gb.display();
    }
}
