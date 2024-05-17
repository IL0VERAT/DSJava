package animate;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class CannonBall {
    public enum STATE {
        IDLE,
        FLYING,
        EXPLODING
    }
    private double x;
    private double y;
    private double vx;
    private double vy;
    private double ax;
    private double ay;
    private STATE currentState;
    private BufferedImage img;


    public CannonBall(double ax, double ay, double ground) {
       
    }

    /* 
    private BufferedImage loadImage(String path) {
        try {
            File imageFile = new File("media/flame01.png");
            img = ImageIO.read(imageFile);
        } catch (Exception fileNotException) {
            System.err.println(fileNotException.getMessage());
        }
    }
    */

    public void draw(Graphics2D g2d) {
        if(currentState == STATE.FLYING){
            g2d.fillOval((int)x-5,(int)y-5,10,10);
        } else if (currentState == STATE.EXPLODING) {
            //include code to show flames and flames moving
        }
    }

    public void updateBall() {
    }

    /*
        How to calculate x position
      vx = vx+ax;
      x = x + vx;
        How to calculate the y position
      vy = vy + ay;
      y = y + vy;

       check if y position is below floor --> then change the state 

     * If the ball is not flying through the air, the launch() method
     * will change the state to FLYING and start the ball moving from position (x,y)
     * with the inital velocity of (vx, vy).
     */
    public void launch(double x, double y, double vx, double vy) {
        //called by cannon --> the cannon uses the trig.
    }

    /*
     * Get/set methods for the private member variables.
     */
    public STATE getState() {
        return currentState;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getVX() {
        return vx;
    }

    public double getVY() {
        return vy;
    }

    public double getAX() {
        return ax;
    }

    public double getAY() {
        return ay;
    }

    //public double getTimeScale() {
    //}

    //public double getGround() {
    //}

    public void setState(STATE newState) {
        currentState = newState;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setVX(double vx) {
        this.vx = vx;
    }

    public void setVY(double vy) {
        this.vy = vy;
    }

    public void setAX(double ax) {
        this.ax = ax;
    }

    public void setAY(double ay) {
        this.ay = ay;
    }

    public void setTimeScale(double timeScale) {
    }

    public void changeTimeScale(double delta) {
    }

    public void setGround(double ground) {
    }

}