public class Ride {
    public static void main(String[] args) {
        Bicycle b = new Bicycle();
        System.out.printf("Speed = %02d%n", b.getSpeed());
        b.pedal();
        b.pedal();
        System.out.printf("Speed = %02d%n", b.getSpeed());

        GearedBicycle gb = new GearedBicycle();
        System.out.printf("Geared Speed = %02d%n", gb.getSpeed());

        gb.shiftUp();
        gb.pedal();
        gb.pedal();
        System.out.printf("Geared Speed = %02d%n", gb.getSpeed());
        System.out.printf("Current Gear = %02d%n", gb.getGear());
    }
}
