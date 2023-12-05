import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;


public class AlternatingSquares {
    //custom method to flip the colors
    public static Color flipColor(Color origColor) {
        if (origColor == Color.RED) { //checks to see what color it is currently and flips it if needed
            return Color.BLUE;
        } else {
            return Color.RED;
        }
    }

    /*
     * Change the following method to customize
     * what is drawn in the JFrame.
     */
    public static void draw(Graphics g) {
        // by default, this method draws a tile board.
        
        Color c = Color.BLUE;//sets the color to start as blue

        int plotX = 0; //variable used to track X
        int plotY = 0; //variable used to track Y
        final int SQUARE_LENTH = 100; //final variable to track square length
        for (int j = 0; j < 4; j++) {//loop that determines when to move down lines
            if (j%2 == 0){ //flips color after lines
                c = Color.BLUE;
            }else{
                c = Color.RED; 
                }
            for (int i = 0; i < 4; i++) { //loop to flip colors in the current line and change positioning
                g.setColor(c);

                plotX = i * SQUARE_LENTH; //finds value of X
                plotY = j * SQUARE_LENTH; //finds value of Y

                g.fillRect(plotX, plotY, SQUARE_LENTH, SQUARE_LENTH); //actually plots out the square

                c = flipColor(c);

            } 
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
