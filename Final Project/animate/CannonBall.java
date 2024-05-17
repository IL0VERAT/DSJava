package animate;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;


public class CannonBall {
    public enum STATE {
        IDLE,
        FLYING,
        EXPLODING
    }

    private double x; // position of center of ball
    private double y; // position of center of ball
    private double vx; // x-velocity
    private double vy; // v-velocity
    private double ax; // x -accel.
    private double ay; // y -acell.
    private STATE currentState;
    private double ground;
    private BufferedImage img1;
    private BufferedImage img2;
    private BufferedImage img3;
    private BufferedImage img4;
    private SoundClip boom;

    public CannonBall(double ax, double ay, double ground) {
        this.ax = ax;
        this.ay = ay;
        this.ground = ground;

        try {
            File imageFile1 = new File("media/flame01.png");
            File imageFile2 = new File("media/flame02.png");
            File imageFile3 = new File("media/flame03.png");
            File imageFile4 = new File("media/flame04.png");
            img1 = ImageIO.read(imageFile1);
            img2 = ImageIO.read(imageFile2);
            img3 = ImageIO.read(imageFile3);
            img4 = ImageIO.read(imageFile3);
        } catch (Exception fileNotException) {
            System.err.println(fileNotException.getMessage());
        }

        boom = new SoundClip("media/boom.wav");
        boom.open(); 
    }

    public void draw(Graphics2D g2d) {
        if (currentState == STATE.FLYING) {
            g2d.fillOval((int) x - 5, (int) y - 5, 10, 10);
        } else if (currentState == STATE.EXPLODING) {
            AffineTransform af = new AffineTransform();
            af.translate(x, ground - 25);
            while(true)
            g2d.drawImage(img1, af, null);
        }
    }

    public void updateBall() {
        if (currentState == STATE.FLYING) {
            vx = vx + ax;
            x = x + vx;
            vy = vy + ay;
            y = y + vy;
            if ((y + 5) > ground) {
                boom.play();
                currentState = STATE.EXPLODING;
            }
        }
    }

    public void launch(double x, double y, double vx, double vy) {
        if (currentState != STATE.FLYING) {
            this.x = x;
            this.y = y;
            this.vy = vy;
            this.vx = vx;
            currentState = STATE.FLYING;
        }
    }

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

    // public double getTimeScale() {
    // }

    public double getGround() {
        return ground;
    }

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
        this.ground = ground;
    }

}