//Coder: Milo Linn-Boggs Date: 4 Dec. 2023
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class MakingARose {
    /*
     * Change the following method to customize
     * what is drawn in the JFrame.
     */
    //method used to create image
    public static void draw(Graphics g) {
        final double STEPS = 10000.0; //changable number of points for the image
        final double SCALE = 150.0; //factor to enlarge the image so it is visible

    for(int i = 0; i < STEPS; i++){ //loops to program for as many STEPS

        double findingTheta = ((2.0 * Math.PI)/STEPS)*i; //finds theta, a variable that will be used in future calculations

        double r = Math.cos(2.0*findingTheta); //finds r, also another variable to be used later

        double findingX = SCALE * r * Math.cos(findingTheta); //finds X, which will eventually be used to plot X cords. in image 

        double findingY = SCALE * r * Math.sin(findingTheta); //finds Y, which will eventually be used to plot Y cords. in image 

        //casts the X and Y to integers to then plot them
        int plotX = (int)findingX; 
        int plotY = (int)findingY;

        g.fillRect(plotX + 199, plotY + 199, 1, 1); //actually creates point positions
        
        }
    }


    public static enum OS {
        WIN, MAC, LINUX, OTHER
    }

    public static OS checkOS() {
        OS val;
        String name = System.getProperty("os.name").toLowerCase();
        if (name.indexOf("win") >= 0) {
            val = OS.WIN;
        } else if (name.indexOf("mac") >= 0) {
            val = OS.MAC;
        } else if (name.indexOf("nux") >= 0) {
            val = OS.LINUX;
        } else {
            val = OS.OTHER;
        }

        return val;
    }

    // Do not modify the code in the main method.
    // Your code will go into the draw method above.
    public static void main(String[] args) {
        // this is the desired dimensions of the content area
        // of our JFrame window.
        final int CONTENT_WIDTH = 400;
        final int CONTENT_HEIGHT = 400;

        // the values for border width and title bar height
        // depend on the operating system.
        int border_width = 0;
        int bar_height = 0;
        OS os = checkOS();
        switch (os) {
            case WIN:
                border_width = 7;
                bar_height = 30;
                break;
            case MAC:
                border_width = 0;
                bar_height = 28;
                break;
            case LINUX:
                // I don't know what the values are for Linux.
                break;
            case OTHER:
                break;
        }

        int frame_width = CONTENT_WIDTH + 2 * border_width;
        int frame_height = CONTENT_HEIGHT + bar_height + border_width;
        JFrame frame = new JFrame();
        frame.setSize(frame_width, frame_height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComponent component = new JComponent() {
            public void paintComponent(Graphics graph) {
                draw(graph);
            }
        };

        frame.add(component);
        frame.setVisible(true);

        System.out.println("Frame Size   : " + frame.getSize());
        System.out.println("Frame Insets : " + frame.getInsets());
        System.out.println("Content Size : " + frame.getContentPane().getSize());
    }

}
