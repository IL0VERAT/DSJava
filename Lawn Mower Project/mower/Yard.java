//Coder: Milo Linn-Boggs Dates: 24 Feb. 2024
/*
I would like to acknowledge Alex Moore for helping out with portions of this code. 
 */
package mower;

import mower.Mower.DIRECTION;

public class Yard {

    // code to create the virtual yard based off user input
    private char[][] yard;

    public Yard(int height, int width) {
        yard = new char[height + 2][width + 2];
        fillYard();
    }

    Yard() {
        yard = new char[10][10];
    }

    // code to fill the yard
    private char[][] fillYard() {
        for (int i = 0; i < yard.length; i++) {
            for (int j = 0; j < yard[i].length; j++) {
                if (i == 0 || i == yard.length - 1 || j == yard[i].length - 1 || j == 0) {
                    yard[i][j] = 'R';
                } else {
                    yard[i][j] = '+';
                }
            }

        }
        return yard;
    }

    // code to print out the yard
    public void printYard() {
        for (int i = 0; i < yard.length; i++) {
            for (int j = 0; j < yard[i].length; j++) {
                System.out.print(yard[i][j]);
            }
            System.out.println();
        }
    }

    public void printYard(Mower mower) {
        for (int i = 0; i < yard.length; i++) {
            for (int j = 0; j < yard[i].length; j++) {
                // if mower there - prints mower -> else print the yard
                if (mower.getRow() == i && mower.getCol() == j) {
                    if (mower.getDirection() == DIRECTION.UP) {
                        System.out.print("^");
                    } else if (mower.getDirection() == DIRECTION.RIGHT) {
                        System.out.print(">");
                    } else if (mower.getDirection() == DIRECTION.LEFT) {
                        System.out.print("<");
                    } else {
                        System.out.print("V");
                    }
                } else {
                    System.out.print(yard[i][j]);
                }
            }
            System.out.println();
        }
    }

    // returns the height of the yard
    public int yardHeight() {
        return yard.length - 2;
    }

    // returns the width of the yard
    public int yardWidth() {
        return yard[0].length - 2;
    }

    // returns the status of the status of cell
    public char getYardCell(int x, int y) {
        return yard[x][y];
    }

    public void setYardCell(int x, int y, char new_character) {
        yard[x][y] = new_character;
    }
}

