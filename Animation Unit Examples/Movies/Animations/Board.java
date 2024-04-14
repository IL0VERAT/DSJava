package Animations;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;

public class Board extends JPanel {
    private final int B_WIDTH = 350;
    private final int B_HEIGHT = 350;
    private int x = 0;
    private int y = 0;
    private final int DIAMETER = 20;
    private Timer timer;
    private final int INITAL_DELAY = 100;
    private final int PERIOD_DELAY = 25;
    private int xSpeed = 2;

    // constructor
    public Board() {
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        x = B_WIDTH/2;
        y = B_HEIGHT/2;

        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduledUpdate(),INITAL_DELAY,PERIOD_DELAY);
    }

    private class ScheduledUpdate extends TimerTask{
        public void run() {
            x += xSpeed;
            if (x > B_WIDTH) {
                x = 0;
            }
            repaint();
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.translate(x - DIAMETER / 2, y - DIAMETER / 2);

        Ellipse2D ellipse = new Ellipse2D.Double(0,0,DIAMETER,DIAMETER);
        Shape transformedShape = affineTransform.createTransformedShape(ellipse);
        g2d.setColor(Color.MAGENTA);
        g2d.fill(transformedShape);

    }
}

