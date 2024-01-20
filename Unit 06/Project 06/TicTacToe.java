import java.util.Scanner;
public class TicTacToe{
    public static char board[][] = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    public static void drawer(char board[][]){ 
     System.out.println("|---|---|---|");
     System.out.println("| "+board[0][0]+" | "+board[0][1]+" | "+board[0][2]+" |");
     System.out.println("|-----------|");             
     System.out.println("| "+board[1][0]+" | "+board[1][1]+" | "+board[1][2]+" |");
     System.out.println("|-----------|");          
     System.out.println("| "+board[2][0]+" | "+board[2][1]+" | "+board[2][2]+ " |");
     System.out.println("|---|---|---|");                
    }
    public static void cleaner(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }
    public static void boardChecker(char board[][]){
        //backup - check each row and column eqaul the same thing. Use & standments and loops
        int toprowX = 0;
        int toprowO = 0;
        int secondrowX = 0;
        int secondrowO = 0;
        int thirdrowX = 0;
        int thirdrowO = 0;
        int rightToLeftX = 0;
        int rightToLeftO = 0;
        int leftToRightX = 0;
        int leftToRightO = 0;
        int column1_X = 0;
        int column2_X = 0;
        int column3_X = 0;
        int column1_O = 0;
        int column2_O = 0;
        int column3_O = 0;
        for(int i = 0; i<3; i++){
            if(board[0][i]==1){
                toprowX++;
            }
            if(board[0][i]==0){
                toprowO++;
            }
            if(board[1][i]==1){
                secondrowX++;
            }
            if(board[1][i]==0){
                secondrowO++;
            }
            if(board[2][i]==1){
                thirdrowX++;
            }
            if(board[2][i]==0){
                thirdrowO++;
            }
            if(board[i][i]==1){
                rightToLeftX++;
            }
            if(board[i][i]==0){
                rightToLeftO++;
            }
            if(board[2 - i][i]==1){
                leftToRightX++;
            }
            if(board[2 - i][i]==0){
                leftToRightO++;
            }
            if(board[i][0]==1){
                column1_X++;
            }
            if(board[i][1]==0){
                column1_O++;
            }
            if(board[i][1]==1){
                column2_X++;
            }
            if(board[i][1]==0){
                column2_X++;
            }
            if(board[i][2]==1){
                column3_X++;
            }
            if(board[i][2]==0){
                column3_X++;
            }
        }
        if(toprowX==3||secondrowX==3||thirdrowX==3||rightToLeftX==3||leftToRightX==3||column1_X==3||column2_X==3||column3_X==3){
            System.out.println("Player One is the winner!");
        } else if(toprowO==3||secondrowO==3||thirdrowO==3||rightToLeftO==3||leftToRightO==3||column1_O==3||column2_O==3||column3_O==3){
            System.out.println("Player Two is the winner!");
        } else {
            System.out.println("It's a tie!");
        }

    }
    public boolean placer(int row, int col, char key){
        if(row < 0 || row > 2){
            System.out.println("ERROR: Row input out of range");
            return false;
        } 

        if(col < 0 || col > 2){
            System.out.println("ERROR: Column input out of range");
            return false;
        }

        if(board[row][col] == ' '){
            board[row][col] = key;
            return true;
        }

        return false;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        int turn = 0;
        int row;
        int col;
        char key;
        while(true){
            TicTacToe.drawer(board);
            //make sure to include a check boolean to see if successful move 
            //make sure to keep track or playerrs and only toggle if successful move (at end)
            if(turn == 8){
                System.out.println("No more possible moves.");
                break;
            }
            if(turn%2 == 0){
                System.out.println("Player One's Turn (X). Please insert the coordinates of your point(row, column) or q to quit: ");
                if (in.hasNext("q") || in.hasNext("Q")) {
                    in.next();
                    System.out.println("Thanks for playing!");
                    break;
                } else {
                //INSERT CHECK CODE TO ENSURE PROPERLY INPUTTED
                //INPUT THE REFERENCE TO THE METHODS TO CHECK IF ANYONE ONE, IF THEY DID OR ITS A TIE, THEN BREAK

            }
            if(turn%2 == 1){
                System.out.println("Player Two's Turn (O). Please insert the coordinates of your point(row, column) or q to quit: ");
                if (in.hasNext("q") || in.hasNext("Q")) {
                    in.next();
                    System.out.println("Thanks for playing!");
                    break;
                } else {
                //INSERT CHECK CODE TO ENSURE PROPERLY INPUTTED
                //INPUT THE REFERENCE TO THE METHODS TO CHECK IF ANYONE ONE, IF THEY DID OR ITS A TIE, THEN BREAK
            }
            cleaner();
            turn++;
            break; //double check 
        }
    }
}
    }
}    