import javax.sound.sampled.LineUnavailableException;

import sound.ToneGenerator;
import sound.ToneGenerator.Note;

public class DemoTone {
    public static void main(String[]args){
        ToneGenerator tg = new ToneGenerator();
        try {
            tg.init();
        } catch (LineUnavailableException e){
            System.err.println("Unable to get audio line");
        }
        tg.play(Note.A3, 1000);
        tg.play(Note.G7, 1000);
    }
}
