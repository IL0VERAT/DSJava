public class SensorExample extends Sensor {
    public SensorExample(String name, int modelNumber) {
        super(name, modelNumber);
    }

    public void recordMeasurement() {
        System.out.print("This needs to do something.");
    }
    
}
