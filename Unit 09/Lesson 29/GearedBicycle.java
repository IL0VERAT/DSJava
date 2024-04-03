public class GearedBicycle extends Bicycle {
    private static final int GEAR_MAX = 6;
    private static final int GEAR_MAX_SPEED = 50;
    private int gear = 1;

    public void setGear(int input) {
        if (input <= GEAR_MAX && input >= 1) {
            gear = input;
        } else {
            gear = 1;
        }
    }

    public int getGear() {
        return gear;
    }

    public void shiftUp() {
        if (gear < GEAR_MAX) {
            gear++;
        } else {
            gear = GEAR_MAX;
        }
    }

    public void shiftDown() {
        if (gear > 1) {
            gear--;
        } else {
            gear = 1;
        }
    }

    public void pedal(){
        //can use only public methods from bicycle class
        int newSpeed = getSpeed() + getGear();
        if(newSpeed > GEAR_MAX_SPEED){
            newSpeed = GEAR_MAX_SPEED;
        }
        this.setSpeed(newSpeed);
    }
    public void display(){
        System.out.printf(" Gear = %02d%n ", gear);
        super.display();
    }
}
