interface Wallet {
    public int getCards();
    public int getBills();

    public void plusCards();
    public void minusCards();

    public void plusBills();
    public void minusBills();
}

class OnlineWallet implements Wallet{
    int cards = 0;
    int bills = 0;
    int credits = 0;

    public int getCards(){
        return cards;
    }

    public int getBills(){
        return bills;
    }
    public int getCredits(){
        return credits;
    }

    public void plusCards(){
        cards = cards + 1;
        credits = credits + 1;
    }

    public void minusCards(){
        if (cards > 0){
            cards = cards - 1;}
    }

    public void plusBills(){
        bills = bills + 1;
        credits = credits + 1;
    }

    public void minusBills(){
       if (bills > 0) {
         bills = bills - 1;}
    }


        }
    

public class InterfaceDemo{
    public static void main (String[]args){
        OnlineWallet ewallet = new OnlineWallet();
        System.out.printf("Number of cards is %d%nNumber of bills is %d%nNumber of credits is %d%n", ewallet.getCards(), ewallet.getBills(), ewallet.getCredits());
        
        System.out.printf("Now lets add a bill and a card to your Online Wallet.%n");
        ewallet.plusBills();
        ewallet.plusCards();
        
        System.out.printf("Number of cards is %d%nNumber of bills is %d%nNumber of credits is %d%n", ewallet.getCards(), ewallet.getBills(), ewallet.getCredits());
        System.out.println("Look, you now have two credits that you got by added a card and a bill to your Online Wallet");
    }
}
