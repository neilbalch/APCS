import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.util.ArrayList;
import java.lang.Thread;

public class Sound {
    private ArrayList urls = new ArrayList();
    private boolean soundPlaying = false;

    private Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
            while(true) {
                if(urls.size() > 0 && !soundPlaying)
                    System.out.println("size: " + urls.size() + " soundPlaying? " + soundPlaying);
                if(urls.size() > 0 && !soundPlaying) {
                    System.out.println("loop");
                    soundPlaying = true;

                    try {
                        Clip clip = AudioSystem.getClip();
                        clip.open(AudioSystem.getAudioInputStream((URL)urls.get(0)));
                        clip.start();
                        System.out.println("playing... " + urls.get(0));

                        // Wait for termination of spin sound.
                        while(clip.getMicrosecondLength() != clip.getMicrosecondPosition()) { }
                        System.out.println("finished playing... " + urls.get(0));
                    } catch (Exception exc) {
                        exc.printStackTrace(System.out);
                    }

                    // Get rid of sound just played
                    urls.remove(0);
                    soundPlaying = false;

                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace(System.out);
                    }
                }
            }
        }
    });

    public void queueSound(String url) {
        urls.add(this.getClass().getClassLoader().getResource(url));
//        System.out.println("Queued: " + url);

        if(!t.isAlive()) t.start();
    }
}
