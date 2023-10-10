//Coder: Milo Linn-Boggs Date: 10 October 2023
interface Wallet { 
    public int getCards();//Lines 3-10: What the new class will implement 
    public int getBills();

    public void plusCards();
    public void minusCards();

    public void plusBills();
    public void minusBills();
}

class OnlineWallet implements Wallet{ //Actuall implementation
    int cards = 0; //Sets values
    int bills = 0;
    int credits = 0;

    public int getCards(){ //Returns # of cards
        return cards;
    }

    public int getBills(){ //Returns # of bills
        return bills;
    }
    public int getCredits(){ // Returns # of credits
        return credits;
    }

    public void plusCards(){ //Adds 1 card and 1 credit
        cards = cards + 1;
        credits = credits + 1;
    }

    public void minusCards(){ //Subtracts 1 card if possible
        if (cards > 0){
            cards = cards - 1;}
    }

    public void plusBills(){ //Addeds 1 bill and 1 credit
        bills = bills + 1;
        credits = credits + 1;
    }

    public void minusBills(){ //Subtracts 1 bill. 
       if (bills > 0) {
         bills = bills - 1;}
    }


        }
    

public class InterfaceDemo{
    public static void main (String[]args){
        OnlineWallet ewallet = new OnlineWallet(); //installs the new OnlineWallet class
        System.out.printf("Number of cards is %d%nNumber of bills is %d%nNumber of credits is %d%n", ewallet.getCards(), ewallet.getBills(), ewallet.getCredits()); //Displays current state of Online Wallet
        
        System.out.printf("Now lets add a bill and a card to your Online Wallet.%n"); //Gives example of some functions for the Online Wallet
        ewallet.plusBills(); //Lines 59-60: Code needed to show the example
        ewallet.plusCards();
        
        System.out.printf("Number of cards is %d%nNumber of bills is %d%nNumber of credits is %d%n", ewallet.getCards(), ewallet.getBills(), ewallet.getCredits()); //Displays the new state of Online Wallet
        System.out.println("Look, you now have two credits that you got by added a card and a bill to your Online Wallet"); //Explains to use the credit system
    }
}
