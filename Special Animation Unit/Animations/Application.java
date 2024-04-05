package Animations;
import javax.swing.JFrame;
public class Application extends JFrame{
    private final int FRAME_WIDTH = 640;
    private final int FRAME_HEIGHT = 480;

    //constructor
    public Application(String title) {
        
        // Use the inherited setTitle() method
        // to set the title for our frame.
        this.setTitle(title);

        // Use the inherited setSize() method
        // to set the size of our frame.
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        // tell Java what you want our window to do
        // when the window is closed by the user, program actually closes
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // specify where to place our window
        // (is it relative to another window?).
        this.setLocationRelativeTo(null);
       
    }

}