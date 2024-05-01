package animate;
import javax.swing.JFrame;
public class Application extends JFrame{

    public static enum OS {
        WIN, MAC, LINUX, OTHER
    }

    //checks the type of operating system
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

    //constructor
    public Application(String title) {
        // Use the inherited setTitle() method
        // to set the title for our frame.
        this.setTitle(title);

        // Use the inherited setSize() method
        // to set the size of our frame.
        //this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        Board board = new Board();
        this.add(board);

        // tell Java what you want our window to do
        // when the window is closed by the user, program actually closes
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // specify where to place our window
        // (is it relative to another window?).
        this.setLocationRelativeTo(null);
       //will need to account for border and bar dimensions
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
               break;
           case OTHER:
               break;
       }

       int application_height = (int) board.getPreferredSize().getHeight() + bar_height + border_width;
       int application_width = (int) board.getPreferredSize().getWidth() + 2 * border_width;
       this.setSize(application_height,application_width);
    }

}