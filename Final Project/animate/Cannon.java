package animate;

import java.io.File;
import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Cannon {
    private SoundClip cannonSound;
    private SoundClip wheelSound;
    private BufferedImage img;
    private double x;
    private double y;
    private double rotation;   
    private final double ROTATION_NUM = 1; 
    private int muzzleVelocity = 37; //may need to change

    //constructor
    public Cannon(double x, double y, double rotation){
        //imports sounds
        cannonSound = new SoundClip("media/cannon.wav");
        cannonSound.open();
        wheelSound = new SoundClip("media/wheel.wav");
        wheelSound.open();

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


    public void fireCannon(){
        cannonSound.play();
    }

    public int getMuzzleVelocity(){
        return muzzleVelocity;
    }

    public void setMuzzleVelocity(int muzzleVelocity){
        this.muzzleVelocity = muzzleVelocity;
    }


    
    public void draw(Graphics2D g2d){
        int x_pivot = 15;
        int y_pivot = img.getHeight()/2;
        AffineTransform affineTransform = new AffineTransform();
        if(img != null){
            //moves photo
            affineTransform.translate(x- x_pivot, y-y_pivot);
            affineTransform.rotate(Math.toRadians(rotation),x_pivot,y_pivot);
            g2d.drawImage(img, affineTransform, null);
            g2d.setColor(Color.BLACK);
            System.out.print("X is " + x);
            System.out.println("Y is" + y);
            g2d.fillOval((int)(x- 5),(int)(y - 5), 10, 10);
        } else {
            g2d.setColor(Color.BLUE);
            g2d.drawString("Unable to load image!", 25, 25);
        }
    }


    public void rotationLeft(double change){
        rotation += change;
        if(rotation > 0){
            rotation = 0;
        }
    }

    public void rotationRight(double change){
         rotation -= change;
        if(rotation < -90){
            rotation = -90;
        }
    }

}
