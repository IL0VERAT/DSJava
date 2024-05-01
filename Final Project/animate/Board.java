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

//private member variable
public class Board extends JPanel implements KeyListener{
    private final int B_WIDTH = 160;
    private final int B_HEIGHT = 90;
    private final int B_FLOOR = B_HEIGHT - 25;

    // constructor
    public Board() {
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        this.setFocusable(true);
        this.addKeyListener(this);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            System.out.println("Spacebar was pressed.");
        } 
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("Left arrow was pressed.");
        } 
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("Right arrow was pressed.");
        } 
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("Up arrow was pressed.");
        } 
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("Left arrow was pressed.");
        } 
    }

    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }

    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
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
