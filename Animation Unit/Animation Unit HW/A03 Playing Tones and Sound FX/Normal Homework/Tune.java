import javax.sound.sampled.LineUnavailableException;
import sound.ToneGenerator;
import sound.ToneGenerator.Note;

public class Tune {
    public static void main(String[] args) throws LineUnavailableException {
        ToneGenerator tg = new ToneGenerator();

        tg.init();
        tg.play(Note.C4, 1000);
        tg.play(Note.REST, 100);
        tg.play(Note.C4, 1000);
        tg.play(Note.D4, 1000);
        tg.play(Note.C4, 1000);
        tg.play(Note.F4, 1000);
        tg.play(Note.E4, 1000);
        tg.play(Note.REST, 200);

        tg.play(Note.C4, 1000);
        tg.play(Note.REST, 100);
        tg.play(Note.C4, 1000);
        tg.play(Note.D4, 1000);
        tg.play(Note.C4, 1000);
        tg.play(Note.G4, 1000);
        tg.play(Note.F4, 1000);
        tg.play(Note.REST, 200);

        tg.play(Note.C4, 1000);
        tg.play(Note.REST, 100);
        tg.play(Note.C4, 1000);
        tg.play(Note.C4, 1000);
        tg.play(Note.A4, 1000);
        tg.play(Note.F4, 1000);
        tg.play(Note.E4, 1000);
        tg.play(Note.D4, 1000);
        tg.play(Note.REST, 200);

        tg.play(Note.B3, 1000);
        tg.play(Note.B3, 1000);
        tg.play(Note.A3, 1000);
        tg.play(Note.F4, 1000);
        tg.play(Note.G4, 1000);
        tg.play(Note.F4, 1000);
        tg.close();   
    }
}
