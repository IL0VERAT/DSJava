package Animations;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import sound.SoundClip;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

//private member variables
public class Board extends JPanel implements KeyListener,MouseListener{
    private final int B_WIDTH = 500;
    private final int B_HEIGHT = 500;
    private final int DIAMETER = 20;
    private SoundClip blip;
    private SoundClip blop;
    private int x = 0;
    private int y = 0;
    private AffineTransform af;

    // constructor
    public Board() {
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        af = new AffineTransform();

        x = 0;
        y = B_HEIGHT / 2;

        blip = new SoundClip("Media/blip.wav");
        blip.open();

        blop = new SoundClip("Media/blop.wav");
        blop.open();

        //needs to be able to get focus of user interface
        this.setFocusable(true);
        //register ourselves as a keylistener object
        this.addKeyListener(this);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            System.out.println("Spacebar was pressed.");
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("Left arrow was pressed.");
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("Right arrow was pressed.");
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("Up arrow was pressed.");
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("Down arrow was pressed.");
        } else {
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {  
    }

    //paints the photo onto window
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        Ellipse2D circle = new Ellipse2D.Double(B_WIDTH/2, B_HEIGHT/2, DIAMETER,DIAMETER);
        Shape transformedShape = af.createTransformedShape(circle);
        g2d.setColor(Color.MAGENTA);
        g2d.fill(transformedShape);
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        af.translate(e.getX(),e.getY());
        g2d.fill
        blip.play();
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}
