import java.util.ArrayList;
import java.util.Scanner;

class CashRegister {
    // member variables
    private ArrayList<Double> items = new ArrayList<>();
    private double cost;
    private int counter;

    // constructor
    public CashRegister() {
        counter = 0;
        cost = 0;
    }

    // adds 1 item to the the
    public void addItem(double price) {
        items.add(price);
        counter++;
    }

    /*
     * Remove the most recently added item from the current sale.
     */
    public void removeItem() {
        items.remove(counter);
        counter--;
    }

    /*
     * Return the current total sales amount.
     */
    public double getTotal() {
        for (int i = 0; i < items.size(); i++) {
            cost += items.get(i);
        }
        return cost;
    }

    /*
     * Return the total count of items in the current sale.
     */
    public int getCount() {
        return counter;
    }

    /*
     * Clear the register (total and count) for a new sale.
     */
    public void clear() {
        items.clear();
        counter = 0;
    }
}

public class CashRegisterEx {
    public static void main(String[] args) {
        CashRegister cashRegister = new CashRegister();
        Scanner in = new Scanner (System.in);
        String input;
        boolean flag = true;

        while(flag == true){
            System.out.print("Enter a price, or t to show total, c to clear, d to delete most recent input, or q to quit:  ");
            input = in.next();
            switch(input.charAt(0)){
                case 't' -> System.out.println("Total = " + cashRegister.getTotal() + " Count = " + cashRegister.getCount());
                case 'c' -> cashRegister.clear();
                case 'd' -> cashRegister.removeItem();
                case 'q' -> flag = false;
                default -> cashRegister.addItem(Double.valueOf(input));
            }
        }
    }
}