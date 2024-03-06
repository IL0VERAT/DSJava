class customer{
    private double total;
    private int count;
    private String name;
    private int region;
    
    public customer(String new_name, int new_region){
        name = new_name;
        region = new_region;
        total = 0;
        count = 0;
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

    public static double getTaxRate(int region){
        return switch(region){
            case 1 -> 0;
            case 2 -> 0.0550;
            case 3 -> 0.0600;
            case 4 -> 0.0625;
            default -> 0;
        };
    }
}
public class CRM{
    public static void main(String[] args) {
        customer c1 = new customer("Harvest Market", 4);
        customer c2 = new customer("Wegman's", 4);

        c1.addSaleAmount(200);
        c1.addSaleAmount(100);

        c2.addSaleAmount(2000);
        
        System.out.printf("%-16s: $%6.2f (%03d) Taxes: $%6.2f %n", c1.getName(), c1.getTotal(), c1.getCount(), c1.getTotalTax());
        System.out.printf("%-16s: $%6.2f (%03d)%n", c2.getName(), c2.getTotal(), c2.getCount());
    }
}