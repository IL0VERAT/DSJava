package mower;

import mower.Yard;

public class Mower {
    private int col;// x
    private int row;// y

    public enum DIRECTION {
        UP, DOWN, LEFT, RIGHT
    };

    private DIRECTION facing;

    public Mower(int new_row, int new_col, DIRECTION dir) {
        facing = dir;
        col = new_col;
        row = new_row;
    }

    Mower() {
        int col = 0;
        int row = 0;
        DIRECTION facing = DIRECTION.UP;
    }

    public DIRECTION getDirection() {
        return facing;
    }

    public void setDirection(DIRECTION dir) {
        facing = dir;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

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

    public void turnRight() {
        facing = switch (facing) {
            case UP -> DIRECTION.RIGHT;
            case RIGHT -> DIRECTION.DOWN;
            case DOWN -> DIRECTION.LEFT;
            case LEFT -> DIRECTION.UP;
        };
    }

    public void turnLeft() {
        facing = switch (facing) {
            case UP -> DIRECTION.LEFT;
            case LEFT -> DIRECTION.DOWN;
            case DOWN -> DIRECTION.RIGHT;
            case RIGHT -> DIRECTION.UP;
        };
    }

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
