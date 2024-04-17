import sound.SoundClip;

public class AudioClip {
    public static void main(String[] args) {
        SoundClip boing = new SoundClip("media/boing.wav");
        SoundClip boing2 = new SoundClip("media/boing.wav");
        boing.open();
        boing2.open();
        boing.play();
        try{
            Thread.sleep(1000);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        boing.play(true);
        boing.close();
    }
}
