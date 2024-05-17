package animate;

import java.io.File;
import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Cannon {
    private SoundClip cannonSound;
    private SoundClip wheelSound;
    private CannonBall ball;
    private BufferedImage img;
    private double x;
    private double y;
    private double rotation;   
    private int muzzleVelocity = 34; 
    private final int HYPOT = 100;
    private int x_pivot;
    private int y_pivot;

    //constructor
    public Cannon(double x, double y, double rotation){
        //imports sounds
        cannonSound = new SoundClip("media/cannon.wav");
        cannonSound.open();
        wheelSound = new SoundClip("media/wheel.wav");
        wheelSound.open();
        ball = new CannonBall(0,1, 743);

        //imports the photo
        try {
            File imageFile = new File("media/sm_cannon.png");
            img = ImageIO.read(imageFile);
        } catch (Exception fileNotException) {
            System.err.println(fileNotException.getMessage());
        }

        //sets x, y, and rotation angle
        this.x = x;
        this.y = y;
        this.rotation = rotation;
    }

    //get and set methods for variables
    public void setX(double x){
        this.x = x;
    }
    public double getX(){
        return x;
    }

    public void setY(double y){
        this.y = y;
    }
    public double getY(){
        return y;
    }

    public void setRotation(double rotation){
        this.rotation = rotation;
    }
    public double getRotation(){
        return rotation;
    }

    //get and set muzzle velocities
    public int getMuzzleVelocity(){
        return muzzleVelocity;
    }

    public void setMuzzleVelocity(int muzzleVelocity){
        this.muzzleVelocity = muzzleVelocity;
    }


    //draws the cannot 
    public void draw(Graphics2D g2d){
        x_pivot = 15;
        y_pivot = img.getHeight()/2;
        AffineTransform affineTransform = new AffineTransform();
        if(img != null){
            //rotates the cannon
            affineTransform.translate(x- x_pivot, y-y_pivot);
            affineTransform.rotate(Math.toRadians(rotation),x_pivot,y_pivot);
            g2d.drawImage(img, affineTransform, null);
            g2d.setColor(Color.BLACK);
            g2d.drawPolygon(new int[]{(int)x,(int)15, (int)105},new int[]{(int)y-5, 743, 743},3);
            g2d.setColor(Color.PINK);
            g2d.fillPolygon(new int[]{(int)x,(int)15, (int)105},new int[]{(int)y-5, 743, 743},3);
            g2d.setColor(Color.BLACK);
            g2d.fillOval((int)(x-5),(int)(y-5), 10, 10);

        } else {
            g2d.setColor(Color.BLUE);
            g2d.drawString("Unable to load image!", 25, 25);
        }
    }

    //fires the cannon
    public void fireCannon(){
        cannonSound.play();
    }

    public void fireCannon(CannonBall ball){
        double x0 = (HYPOT * Math.cos(Math.toRadians(Math.abs(rotation))));
        double y0 = (HYPOT * Math.sin(Math.toRadians(Math.abs(rotation))));
        double vx0 = (muzzleVelocity * Math.cos(Math.toRadians(Math.abs(rotation))));
        double vy0 = -(muzzleVelocity * Math.sin(Math.toRadians(Math.abs(rotation))));
        double x = getX() + x0;
        double y = getY() - y0;
        ball.launch(x, y, vx0, vy0);
        System.out.println(x +", "+y+ ", "+vy0+", "+vx0);
        this.fireCannon();
    }

    //ensures cannon does not over rotate
    public void rotationLeft(double change){
        if((rotation -= change) < -90){
            rotation = -90;
        } else {
            rotation -= change;
            wheelSound.play();
        }
    }

    public void rotationRight(double change){
        if((rotation += change) > 0){
            rotation = 0;
        } else{
            rotation += change;
            wheelSound.play();
        }
    }

}
