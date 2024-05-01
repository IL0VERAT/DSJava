package animate;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;

//private member variables
public class Board extends JPanel implements KeyListener{
    private final int B_WIDTH = 1600;
    private final int B_HEIGHT = 900;
    private final int B_FLOOR = B_HEIGHT - 25;

    // constructor
    public Board() {
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

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
        AffineTransform affineTransform = new AffineTransform();
        g2d.drawLine(0, B_FLOOR, B_WIDTH, B_FLOOR);

        Rectangle rect = new Rectangle(0,(B_FLOOR+1), B_WIDTH, (B_FLOOR+1));
        Shape transformedShape = affineTransform.createTransformedShape(rect);
        g2d.setColor(Color.GREEN);
        g2d.fill(transformedShape);
    }
}
