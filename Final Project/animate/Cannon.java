package animate;

import java.io.File;
import javax.imageio.ImageIO;
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

    //may need to split up later if logic errors --> put negative in with affineTransform
    public double rotationMachine(double rotation){
        if(rotation >= 90.0 || rotation <= 0){
            //do something here?
        } else {
            rotation = rotation + ROTATION_NUM;
            //will need to control with key presses whether + or -. 
        }
        return rotation;
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


    
    //make draw method --< takes graphics 2d object --> in board function --> have graphics function that 

}
