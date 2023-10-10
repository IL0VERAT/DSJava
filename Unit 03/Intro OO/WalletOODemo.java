//Coder: Milo Linn-Boggs Date: 10 October 2023
class Wallet{ //class created
    final int MAX_CARDS = 15; //Lines 3-6: Details about the class 
    final int MAX_BILLS = 25;
    int cards = 0;
    int bills = 0;

    public int getCards(){ //Returns the # of cards
        return cards;
    }
    public int getBills(){ //Returns the # of bills
        return bills;
    }

    public void plusCards(){ //Adds 1 card to wallet if possible
        //increases # of cards if possible
        if (cards < MAX_CARDS){
            cards = cards + 1;
        }
    }

    public void minusCards(){ //subtracts 1 card from wallet if possible
        if (cards > 0){
            cards = cards - 1;
        }

    }

    public void plusBills(){ //Adds 1 bill to wallet if possible
        if (bills < MAX_BILLS){
            bills = bills + 1;
        }
    }

    public void minusBills(){ // Subtracts 1 bill from wallet if possible
        if (bills > 0){
            bills = bills - 1;
        }
    }


}
public class WalletOODemo { //Program class
    public static void main (String[]args){
        Wallet wallet = new Wallet(); //installs the class created
        System.out.printf("The number of cards in your wallet is %d and the number of bills is %d" ,wallet.getCards(), wallet.getBills()); //Displays wallets current status to user
        System.out.printf("%nNow the computer will add 1 card and 1 bill to the wallet."); //Example of what program can do
        wallet.plusCards(); //Lines 48-49: Code needed to add 1 card and 1 bill
        wallet.plusBills();
        System.out.printf("%nYour wallet now has %d cards and %d bills.", wallet.getCards(), wallet.getBills()); //Shows user result
    }
}