package sound;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundClip {
    private String filePath;
    private File audioFile;
    private AudioInputStream audioIn;
    private Clip clip; // makes raw data easy to use

    public SoundClip(String path) {
        filePath = path;
        clip = null;
    }

    public void open() {
        try {
            audioFile = new File(filePath);
            audioIn = AudioSystem.getAudioInputStream(audioFile.getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioIn);
        } catch (UnsupportedAudioFileException e) {
            System.err.println("Unable to initialize the Clip.  Unsupported audio file.");
            System.err.println(e.getMessage());
            clip = null;
            return;
        } catch (IOException e) {
            System.err.println("Unable to initialize the Clip.  IO Exception.");
            System.err.println(e.getMessage());
            return;
        } catch (LineUnavailableException e) {
            System.err.println("Unable to initialize the Clip.  Line unavailable.");
            System.err.println(e.getMessage());
            return;
        }
 
    }

    public void play() {
        // implement method here.
    }

    public void play(boolean wait) {
        // implement method here.
    }

    public void close() {
        // implement method here.
    }
}
