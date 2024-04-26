import Animations.Application;
import sound.SoundClip;

import java.awt.EventQueue;

public class DemoApp {
    public static void main(String[] args) {
        //puts command in event thread; Java system does it. Otherwise may cause issues
        EventQueue.invokeLater(() -> {
            Application myApp = new Application("MY DEMO");
            myApp.setVisible(true);
        });

        SoundClip sitar = new SoundClip("Media/sitar.wav");
        while(true){
        sitar.open();
        sitar.play();
        sitar.play(true);
        }
    }
}
    
