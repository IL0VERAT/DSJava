import sound.SoundClip;

public class AudioClip {
    public static void main(String[] args) {
        SoundClip boing = new SoundClip("media/boing.wav");
        boing.open();
        boing.play();
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        boing.close();
    }
}
