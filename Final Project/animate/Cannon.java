package animate;

import javax.imageio.ImageIO;

public class Cannon {
    private SoundClip cannonSound;
    private SoundClip wheelSound;
    //constructor
    public Cannon(){
        cannonSound = new SoundClip("media/cannon.wav");
        wheelSound = new SoundClip("media/wheel.wav");
    }
}
