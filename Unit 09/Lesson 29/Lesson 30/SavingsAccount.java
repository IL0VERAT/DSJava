public class SavingsAccount extends Account {
    public static final double FEE_THRESHOLD = 500;
    public static double FEE_AMOUNT = 2;

    public SavingsAccount(int id, double initBalance) {
        super(id, initBalance);
    }

    public void deductFees() {
        // we must implement the deductFees() method.
        // only deduct fees if their balance is below the threshold value.
        if (getBalance() < FEE_THRESHOLD) {
            setBalance(getBalance() - FEE_AMOUNT);
        }
    }
}
