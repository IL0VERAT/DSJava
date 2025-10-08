//Coder: Milo Linn-Boggs Date: 19 April 2024
package Animations;

import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import sound.SoundClip;

//private member variable
public class Board extends JPanel {
    private final int B_WIDTH = 720;
    private final int B_HEIGHT = 720;
    private int x = 0;
    private int y = 0;
    private Timer timer;
    private final int INITAL_DELAY = 100;
    private final int PERIOD_DELAY = 25;
    private int xSpeed = 2;
    private int ySpeed = 5;
    private int angle = 0;
    private BufferedImage img;
    private SoundClip sitar;
    private SoundClip ow;

    // constructor
    public Board() {
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        x = B_WIDTH / 2;
        y = B_HEIGHT / 2;

        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduledUpdate(), INITAL_DELAY, PERIOD_DELAY);

        //imports the photo
        try {
            File imageFile = new File("Media/Andy.png");
            img = ImageIO.read(imageFile);
        } catch (Exception fileNotException) {
            System.err.println(fileNotException.getMessage());
        }

        //open sound file
        sitar = new SoundClip("Media/sitar.wav");
        sitar.open();
        sitar.setLoop(true);
        sitar.play();

        //open ow sound
        ow = new SoundClip("Media/ow.wav");
        ow.open();

        //randomly assigns the speed
        xSpeed = (int) (Math.random() * 5 + 1);
        ySpeed = (int) (Math.random() * 5 + 1);
    }

    //moves the photo
    private class ScheduledUpdate extends TimerTask {
        public void run() {
            x += xSpeed;
            if (x > B_WIDTH ||x < 0) {
                ow.play();
                xSpeed = -xSpeed;
            }
            y += ySpeed;
            if (y > B_HEIGHT || y < 0) {
                ow.play();
                ySpeed = -ySpeed;
            }
            angle += 5; //in degrees
            angle = angle%360;

            repaint();
        }
    }

    //paints the photo onto window
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform affineTransform = new AffineTransform();
        if (img != null) {
            affineTransform.translate(x - img.getWidth() / 2, y - img.getHeight() / 2);
            //rotates image
            affineTransform.rotate(Math.toRadians(angle),img.getWidth() / 2, img.getHeight() / 2);
            g2d.drawImage(img, affineTransform, null);
        } else {
            g2d.drawString("Image is null", 100, 100);
        }
    }
}
