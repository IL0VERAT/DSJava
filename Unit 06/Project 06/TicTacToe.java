import java.util.Scanner;
public class TicTacToe{
    public static void drawer(int[][]board){
     System.out.println("|---|---|---|");
     System.out.println("|"+board[1][1]+"|"+board[1][2]+"|"+board[1][3]+"|");
     System.out.println("|-----------|");             
     System.out.println("|"+board[2][1]+"|"+board[2][2]+"|"+board[2][3]+"|");
     System.out.println("|-----------|");          
     System.out.println("| 7 | 8 | 9 |");
     System.out.println("|---|---|---|");                
    }
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        int board[][] = new int [3][3];
        int turn = 0;
        while(true){
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
        }
    }
}