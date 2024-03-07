//Coder: Milo Linn-Boggs Date: 7 Mar. 2024
import java.util.ArrayList;
import java.util.Scanner;
class CashRegister {
    // member variables
    private ArrayList<Double> items;

    // constructor
    public CashRegister() {
        items = new ArrayList<>();
    }

    // adds 1 item to the the
    public void addItem(double price) {
        items.add(price);
    }

    /*
     * Remove the most recently added item from the current sale.
     */
    public void removeItem() {
        if (items.size() > 0){
            items.remove(items.size() - 1);
        }
    }

    /*
     * Return the current total sales amount.
     */
    public double getTotal() {
        double value = 0;
        for(int i = 0; i < items.size(); i++){
            value += items.get(i);
        }
        return value;
    }

    /*
     * Return the total count of items in the current sale.
     */
    public int getCount() {
        return items.size();
    }

    /*
     * Clear the register (total and count) for a new sale.
     */
    public void clear() {
        items.clear();
    }
}

public class CashRegisterEx {
    public static void main(String[] args) {
        CashRegister cashRegister = new CashRegister();
        Scanner in = new Scanner(System.in);
        String input;
        boolean flag = true;

        while (flag == true) {
            System.out.print(
                    "Enter a price, or t to show total, c to clear, d to delete most recent input, or q to quit:  ");
            input = in.next();
            switch (input.charAt(0)) {
                case 't' ->
                    System.out.println("Total = " + cashRegister.getTotal() + " Count = " + cashRegister.getCount());
                case 'c' -> cashRegister.clear();
                case 'd' -> cashRegister.removeItem();
                case 'q' -> flag = false;
                default -> cashRegister.addItem(Double.valueOf(input));
            }
        }
    }
}