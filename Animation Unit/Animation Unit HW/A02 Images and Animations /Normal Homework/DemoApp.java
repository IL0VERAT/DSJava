import Animate.Application;
import java.awt.EventQueue;

public class DemoApp {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Application myApp = new Application("MY DEMO");
            myApp.setVisible(true);
        });
    }
}
