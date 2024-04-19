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
    private final int B_WIDTH = 620;
    private final int B_HEIGHT = 620;
    private BufferedImage img;

    // constructor
    public Board() {
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        try {
            File imageFile = new File("Images/dolomites.jpg");
            img = ImageIO.read(imageFile);
            setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
        } catch (Exception fileNotException){
            System.err.println(fileNotException.getMessage());
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform affineTransform = new AffineTransform();
        int x_t = 0, y_t = 0;
        int x_scaled = 0, y_scaled = 0;
        double scale = 0.25;
        if(img != null){
            x_t = this.getWidth() / 2;
            x_scaled = (int) ((img.getWidth() * scale) / 2.0);
            y_t = this.getHeight() / 2;
            y_scaled = (int) ((img.getHeight() * scale) / 2.0);
            affineTransform.translate(x_t + x_scaled, y_t + y_scaled);
            affineTransform.scale(scale, scale);
            g2d.drawImage(img, affineTransform, null);
        } else {
            g2d.setColor(Color.BLUE);
            g2d.drawString("Unable to load image!", 25, 25);
    }
}
}
