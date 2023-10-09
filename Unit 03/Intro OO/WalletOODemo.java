class Wallet{
    final int MAX_CARDS = 15;
    final int MAX_BILLS = 25;
    int cards = 0;
    int bills = 0;

    public int getCards(){
        return cards;
    }
    public int getBills(){
        return bills;
    }

    public void plusCards(){
        //increases # of cards if possible
        if (cards < MAX_CARDS){
            cards = cards + 1;
        }
    }

    public void minusCard(){
        if (cards > 0){
            cards = cards - 1;
        }

    }

    public void plusBills(){
        if (bills < MAX_BILLS){
            bills = bills + 1;
        }
    }

    public void minusBills(){
        if (bills > 0){
            bills = bills - 1;
        }
    }


}
public class WalletOODemo {
    public static void main (String[]args){
        Wallet wallet = new Wallet();
        System.out.printf("The number of cards in your wallet is %d and the number of bills is %d" ,wallet.getCards(), wallet.getBills());
        System.out.printf("%nNow the computer will add 1 card and 1 bill to the wallet.");
        wallet.plusCards();
        wallet.plusBills();
        System.out.printf("%nYour wallet now has %d cards and %d bills.", wallet.getCards(), wallet.getBills());
    }
}