package Animations;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import sound.SoundClip;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


//private member variables
public class Board extends JPanel implements KeyListener,MouseListener{
    private final int B_WIDTH = 500;
    private final int B_HEIGHT = 500;
    private final int DIAMETER = 20;
    private SoundClip blip;
    private SoundClip blop;
    private int x = 0;
    private int y = 0;

    // constructor
    public Board() {
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        x = B_WIDTH/2;
        y = B_HEIGHT / 2;

        blip = new SoundClip("Media/blip.wav");
        blip.open();

        blop = new SoundClip("Media/blop.wav");
        blop.open();

        //needs to be able to get focus of user interface
        this.setFocusable(true);
        //register ourselves as a keylistener object
        this.addKeyListener(this);
        //register ourselves as a mouselistener object
        this.addMouseListener(this);
    }

    public void keyPressed(KeyEvent e) {

        //reacts to keyboard or mouse presses
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            System.out.println("Spacebar was pressed.");
            x = B_WIDTH/2;
            y = B_HEIGHT/2;
            repaint();
            blop.play();
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

    //paints the circle onto window
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.MAGENTA);
        g2d.fillOval(x - DIAMETER/2, y - DIAMETER/2, DIAMETER, DIAMETER);
    }

    public void mouseClicked(MouseEvent e) {
    }

    //moves circle to point mouse pressed
    public void mousePressed(MouseEvent e) {
        System.out.println("Hi");
        x = e.getX();
        y = e.getY();
        repaint();
        blip.play();
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}
