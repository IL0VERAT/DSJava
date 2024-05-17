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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.util.Timer;
import java.util.TimerTask;

//private member variables
public class Board extends JPanel implements KeyListener,MouseListener{
    private final int B_WIDTH = 1366;
    private final int B_HEIGHT = 768;
    private final int B_FLOOR = B_HEIGHT - 25;
    private final int INITAL_DELAY = 0;
    private final int PERIOD_DELAY = 20;
    private Timer timer;
    private Cannon cannon;
    private CannonBall ball;

    // constructor
    public Board() {
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        cannon = new Cannon(60, B_HEIGHT-60, -45);
        ball = new CannonBall(0, 1, B_FLOOR);

        //needs to be able to get focus of user interface
        this.setFocusable(true);
        //register ourselves as a keylistener object
        this.addKeyListener(this);

        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduledUpdate(), INITAL_DELAY, PERIOD_DELAY);
    }

    private class ScheduledUpdate extends TimerTask {
        public void run() {
           ball.updateBall();
           repaint();
        }
    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            cannon.fireCannon(ball);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            cannon.rotationLeft(1.0);
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            cannon.rotationRight(1.0);
            repaint();
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
        g2d.drawLine(0, B_FLOOR, B_WIDTH-1, B_FLOOR);

        Rectangle rect = new Rectangle(0,(B_FLOOR+1), B_WIDTH, (B_FLOOR+1));
        Shape transformedShape = affineTransform.createTransformedShape(rect);
        g2d.setColor(Color.GREEN);
        g2d.fill(transformedShape);
        cannon.draw(g2d);
        ball.draw(g2d);
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}
