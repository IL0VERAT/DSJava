import Animate.Application;
import java.awt.EventQueue;

public class DemoApp {
    public static void main(String[] args) {
        // Application myApp = new Application("MY DEMO");
        // myApp.setVisible(true);

        //puts command in event thread; Java system does it. Otherwise may cause issues
        EventQueue.invokeLater(() -> {
            Application myApp = new Application("MY DEMO");
            myApp.setVisible(true);
        });
    }
}
