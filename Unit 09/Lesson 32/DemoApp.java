import Animations.Application;

import java.awt.EventQueue;

public class DemoApp {
    public static void main(String[] args) {
        //puts command in event thread; Java system does it. Otherwise may cause issues
        EventQueue.invokeLater(() -> {
            Application myApp = new Application("Wild Ride");
            myApp.setVisible(true);
        });
    }
}
    
