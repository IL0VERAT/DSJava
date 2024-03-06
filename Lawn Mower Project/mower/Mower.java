package mower;
import mower.Yard;
public class Mower {
    private int x;
    private int y;
    private enum DIRECTION{UP, DOWN, LEFT, RIGHT};
    private DIRECTION facing;

    public Mower (int X, int Y, DIRECTION dir){
        DIRECTION facing = dir;
        int x = X;
        int y = Y;
    }Mower() {int x = 0; int y = 0; DIRECTION facing = DIRECTION.UP;}

    public DIRECTION getDirection(){
        return facing;
    }

    public void setDirection(DIRECTION dir){
        facing = dir;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setPos(int X, int Y){
        x = X;
        y = Y;
    }

    public char withinYard(Yard yard){
        char within;
        int withinY = switch (facing){
            case UP -> y+1;
            case DOWN -> y-1;
            default -> y;
        };
        int withinX = switch (facing){
            case RIGHT -> x-1;
            case LEFT -> x+1;
            default -> x;
        };
        within = yard.position(withinX, withinY);
        return within;
    }

    public void turnRight(){
    facing = switch (facing) {
        case UP -> DIRECTION.RIGHT;
        case RIGHT -> DIRECTION.DOWN;
        case DOWN -> DIRECTION.LEFT;
        case LEFT -> DIRECTION.UP;
    };

    public void turnLeft(){
        facing = switch (facing) {
            case UP -> DIRECTION.LEFT;
            case LEFT -> DIRECTION.DOWN; 
            case DOWN -> DIRECTION.RIGHT;
            case RIGHT -> DIRECTION.UP;
        };
    }

    public void drive(){
        switch(facing){
            case UP -> y+=1;
            case DOWN -> y-=1;
            case LEFT -> x +=1;
            case RIGHT -> x-=1;
        };
    }
}
    
}
