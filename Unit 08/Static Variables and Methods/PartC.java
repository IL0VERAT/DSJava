/*class customer{
    private double total;
    private int count;
    private String name;
    private int region;
    private int serial_number;

    public customer(String new_name, int new_region){
        name = new_name;
        region = new_region;
        total = 0;
        count = 0;

        //assign serial number.
        last_serial_used++;
        serial_number = last_serial_used;
    }

    public customer(String name){
        //calls this.customer from the top one --> this. is implicit parameter
        this(name, 1);
    }

    public int getSerial(){
        return serial_number;
    }

    public double getTotal(){
        return total;
    }

    public int getCount(){
        return count;
    }

    public void addSaleAmount(double newAmount){
        total = total + newAmount;
        count++;
    }

    public void clearTotal(){
        total = 0;
        count = 0;
    }

    public String getName(){
        return name;
    }

    public void setName(String new_name){
        name = new_name;
    }

    public int getRegion(){
        return region;
    }

    public void setRegion(int new_region){
        region = new_region;
    }

    public double getTotalTax(){
        double rate = getTaxRate(region);
        return rate * total;
    }

    //static variable
    public static int last_serial_used = 0;

    //static method
    public static double getTaxRate(int region){
        return switch(region){
            case 1 -> 0; //NH
            case 2 -> 0.0550; //ME
            case 3 -> 0.0600; //VT
            case 4 -> 0.0625; //MA
            default -> 0; //should throw an error instead
        };
    }
}
public class PartC {
    public static void main(String[] args) {
        customer.last_serial_used = 100;
        customer c1 = new customer("Sal's Deli");
        c1.addSaleAmount(100);
        customer c2 = c1;
        c2.addSaleAmount(50);
        System.out.println(c1.getTotal());
        System.out.println(c2.getTotal());
    }
 
}*/

//This code prints out 150.0 then, on the next line, 150.0
/*Because both c1 and c2 point to the same space in memory, what ever you do to one variable will effect the other.
 * In other words, c1 and c2 refer to the same object
*/
