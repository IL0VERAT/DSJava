import java.util.Scanner;
public class TicTacToe{
    public static void drawer(int board[][]){
     System.out.println("|---|---|---|");
     System.out.println("| "+board[0][0]+" | "+board[0][1]+" | "+board[0][2]+" |");
     System.out.println("|-----------|");             
     System.out.println("| "+board[1][0]+" | "+board[1][1]+" | "+board[1][2]+" |");
     System.out.println("|-----------|");          
     System.out.println("| "+board[2][0]+" | "+board[2][1]+" | "+board[2][2]+ " |");
     System.out.println("|---|---|---|");                
    }
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        int board[][] = new int [3][3];
        int turn = 0;
        boolean breaker = false;
        TicTacToe.drawer(board);
        while(breaker == false){
            if(turn%2 == 0){
                System.out.println("Player One's Turn (X). Please insert the coordinates of your point(row, column): ");
                //INSERT CHECK CODE TO ENSURE PROPERLY INPUTTED
                //INPUT THE REFERENCE TO THE METHODS TO CHECK IF ANYONE ONE, IF THEY DID OR ITS A TIE, THEN BREAK
            }
            if(turn%2 == 1){
                System.out.println("Player Two's Turn (O). Please insert the coordinates of your point(row, column): ");
                //INSERT CHECK CODE TO ENSURE PROPERLY INPUTTED
                //INPUT THE REFERENCE TO THE METHODS TO CHECK IF ANYONE ONE, IF THEY DID OR ITS A TIE, THEN BREAK
            }
            turn++;
            breaker = true;
        }
    }
}