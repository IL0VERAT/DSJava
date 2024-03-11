//Coder: Milo Linn-Boggs Date: 11 Mar. 2024
package mower;

import mower.Yard;

public class Mower {
    private int col;// x
    private int row;// y

    //tracks lawn mower direction
    public enum DIRECTION {
        UP, DOWN, LEFT, RIGHT
    };

    private DIRECTION facing;

    //constructor
    public Mower(int new_row, int new_col, DIRECTION dir) {
        facing = dir;
        col = new_col;
        row = new_row;
    }

    //overloaded constructor
    Mower() {
        int col = 0;
        int row = 0;
        DIRECTION facing = DIRECTION.UP;
    }

    //gets the direction of lawn mower
    public DIRECTION getDirection() {
        return facing;
    }

    //sets lawn mower direction
    public void setDirection(DIRECTION dir) {
        facing = dir;
    }

    //gets the column
    public int getCol() {
        return col;
    }

    //gets the row
    public int getRow() {
        return row;
    }

    //sets the position of lawn mower
    public void setPos(int new_row, int new_col) {
        row = new_row;
        row = new_col;
    }

    // checks if the unit is a wall. If not, then it turns character into space
    public void mow(Yard yard) {
        int col = this.getCol();
        int row = this.getRow();
        if (yard.getYardCell(row, col) == '+') {
            yard.setYardCell(row, col, ' ');
        }
    }

    //checks the status of lawn in front of lawn mower
    public char checkGrass(Yard yard) {
        char within;
        int withinRow = switch (facing) {
            case UP -> row - 1;
            case DOWN -> row + 1;
            default -> row;
        };
        int withinCol = switch (facing) {
            case RIGHT -> col + 1;
            case LEFT -> col - 1;
            default -> col;
        };
        within = yard.getYardCell(withinRow, withinCol);
        return within;
    }

    //turns lawn mower right
    public void turnRight() {
        facing = switch (facing) {
            case UP -> DIRECTION.RIGHT;
            case RIGHT -> DIRECTION.DOWN;
            case DOWN -> DIRECTION.LEFT;
            case LEFT -> DIRECTION.UP;
        };
    }

    //turns lawn mower left
    public void turnLeft() {
        facing = switch (facing) {
            case UP -> DIRECTION.LEFT;
            case LEFT -> DIRECTION.DOWN;
            case DOWN -> DIRECTION.RIGHT;
            case RIGHT -> DIRECTION.UP;
        };
    }

    //moves the lawn mower forward
    public void mover() {
        switch (facing) {
            case UP -> row -= 1;
            case DOWN -> row += 1;
            case LEFT -> col -= 1;
            case RIGHT -> col += 1;
        }
        ;
    }
}
