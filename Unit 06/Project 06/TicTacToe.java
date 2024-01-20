import java.util.Scanner;

public class TicTacToe {
    public static char board[][] = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
    public static int turn = 0;

    public static void drawer(char board[][]) {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " |");
        System.out.println("|---|---|---|");
    }

    public static void cleaner() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void boardChecker(char board[][]) {
        if (board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X') {
            System.out.println("Player One wins!");
        } else if (board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X') {
            System.out.println("Player One wins!");
        } else if (board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X') {
            System.out.println("Player One wins!");
        } else if (board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X') {
            System.out.println("Player One wins!");
        } else if (board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X') {
            System.out.println("Player One wins!");
        } else if (board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X') {
            System.out.println("Player One wins!");
        } else if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') {
            System.out.println("Player One wins!");
        } else if (board[2][0] == 'X' && board[1][1] == 'X' && board[0][2] == 'X') {
            System.out.println("Player One wins!");
        } else if(turn == 8) {
            System.out.println("The games a tie!");
        }

        if (board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O') {
            System.out.println("Player Two wins!");
        } else if (board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O') {
            System.out.println("Player Two wins!");
        } else if (board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O') {
            System.out.println("Player Two wins!");
        } else if (board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O') {
            System.out.println("Player Two wins!");
        } else if (board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O') {
            System.out.println("Player Two wins!");
        } else if (board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O') {
            System.out.println("Player Two wins!");
        } else if (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') {
            System.out.println("Player Two wins!");
        } else if (board[2][0] == 'O' && board[1][1] == 'O' && board[0][2] == 'O') {
            System.out.println("Player Two wins!");
        } else {

        }

        if(turn == 8) {
            System.out.println("The games a tie!");
        }
    }

    public static boolean placer(int row, int col, char key) {
        if (row < 0 || row > 2) {
            System.out.println("ERROR: Row input out of range");
            return false;
        }

        if (col < 0 || col > 2) {
            System.out.println("ERROR: Column input out of range");
            return false;
        }

        if (board[row][col] == ' ') {
            board[row][col] = key;
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row;
        int col;
        char key;
        while (true) {
            // make sure to include a check boolean to see if successful move
            // make sure to keep track or playerrs and only toggle if successful move (at
            // end)
            if (turn == 8) {
                System.out.println("No more possible moves. It's a tie.");
                break;
            }
            if (turn % 2 == 0) {
                TicTacToe.drawer(board);
                System.out.println(
                        "Player One's Turn (X). Please insert the coordinates of your point(row column) or q to quit: ");
                if (in.hasNext("q") || in.hasNext("Q")) {
                    in.next();
                    System.out.println("Thanks for playing!");
                    break;
                }
                col = in.nextInt();
                row = in.nextInt();
                key = ('X');
                TicTacToe.placer(row, col, key);
            }
            if (turn % 2 == 1) {
                TicTacToe.drawer(board);
                System.out.println(
                        "Player Two's Turn (O). Please insert the coordinates of your point(row, column) or q to quit: ");
                if (in.hasNext("q") || in.hasNext("Q")) {
                    in.next();
                    System.out.println("Thanks for playing!");
                    break;
                }
                col = in.nextInt();
                row = in.nextInt();
                key = ('O');
                TicTacToe.placer(row, col, key);
            }
            turn++;
            boardChecker(board);
            cleaner();
        }
    }
}
