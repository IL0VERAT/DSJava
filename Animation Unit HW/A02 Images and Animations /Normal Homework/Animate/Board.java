//Coder: Milo Linn-Boggs Date: 19 April 2024
package Animate;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Board extends JPanel {
    private final int B_WIDTH = 500;
    private final int B_HEIGHT = 300;
    private BufferedImage img;

    // constructor
    public Board() {
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        //imports image
        try {
            File imageFile = new File("Images/dolomites.jpg");
            img = ImageIO.read(imageFile);
            setPreferredSize(new Dimension(img.getWidth(),img.getHeight()));
        } catch (Exception fileNotException){
            System.err.println(fileNotException.getMessage());
        }
    }

    //paints the photo
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform affineTransform = new AffineTransform();
        double scale = 0.5;
        if(img != null){
            //moves photo
            affineTransform.translate(getWidth()/2, getHeight()/2);
            affineTransform.scale(scale, scale);
            g2d.drawImage(img, affineTransform, null);
        } else {
            g2d.setColor(Color.BLUE);
            g2d.drawString("Unable to load image!", 25, 25);
    }
}
}
