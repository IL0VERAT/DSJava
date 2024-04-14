package Animate;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Board extends JPanel {
    private final int B_WIDTH = 350;
    private final int B_HEIGHT = 350;
    private final int SIDE_LENGTH = 150;
    private BufferedImage img;

    // constructor
    public Board() {
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.fillRect((B_WIDTH/2) - (SIDE_LENGTH / 2), (B_HEIGHT/2) - (SIDE_LENGTH/2), SIDE_LENGTH, SIDE_LENGTH);
        int x_t = B_WIDTH/2;
        int y_t = B_HEIGHT/2;
        x_t = x_t - SIDE_LENGTH/2;
        y_t = y_t - SIDE_LENGTH/2;

        AffineTransform affineTransform = new AffineTransform();
        affineTransform.translate(x_t, y_t);

        Rectangle rect = new Rectangle(0,0, SIDE_LENGTH, SIDE_LENGTH);

        Shape transformedShape = affineTransform.createTransformedShape(rect);

        g2d.setColor(Color.MAGENTA);

        g2d.fill(transformedShape);
    }
}

