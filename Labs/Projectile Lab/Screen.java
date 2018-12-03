import javax.swing.JPanel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Screen extends JPanel implements KeyListener {
    private Player player;
    private Target[] targets;
    private Projectile[] projectiles;
    private int previousNumHit;

    private void playSound(String url) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(this.getClass().getClassLoader().getResource(url)));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }

    public Screen() {
        player = new Player(50, 300);

        targets = new Target[15];
        for(int i = 0; i < targets.length; i++) {
            if(i%3 == 0)
                targets[i] = new Target((int)(400 * Math.random() + 300), (int)(500 * Math.random()), new Color(247, 54, 33));
            if(i%3 == 1)
                targets[i] = new Target((int)(400 * Math.random() + 300), (int)(500 * Math.random()), new Color(7, 255, 0));
            if(i%3 == 2)
                targets[i] = new Target((int)(400 * Math.random() + 300), (int)(500 * Math.random()), new Color(148, 35, 255));
        }

        projectiles = new Projectile[3];
        for(int i = 0; i < projectiles.length; i++) {
            projectiles[i] = new Projectile(75, 350);
        }

        previousNumHit = 0;

        //sets keylistener
        setFocusable(true);
        addKeyListener(this);
    }

    public Dimension getPreferredSize() {
        //Sets the size of the panel
        return new Dimension(800, 600);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.YELLOW);
        g.fillRect(0, 0, 250, 600);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(250, 0, 800 - 250, 600);

        //Draw player
        player.drawMe(g);

        int numHit = 0;
        for(int i = 0; i < targets.length; i++) {
            targets[i].drawMe(g);
            if(targets[i].isHit()) {
                numHit++;
            }
        }
        for(int i = 0; i < numHit - previousNumHit; i++) {
            playSound("hit.wav");
        }
        previousNumHit = numHit;

        //Draw Projectile
        for(int i = 0; i < projectiles.length; i++) {
            projectiles[i].drawMe(g);
        }

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 18));
        g.drawString(numHit == targets.length ? "All targets are hit!" : "Number of Targets Hit: " + numHit, 25, 25);
    }

    public void animate() {
        while(true) {
            //wait for .01 second
            try {
                Thread.sleep(10);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            for(int i = 0; i < projectiles.length; i++) {
                projectiles[i].move(3, 0);
                for (int j = 0; j < targets.length; j++)
                    targets[j].checkCollision(projectiles[i]);
            }

            //repaint the graphics drawn
            repaint();
        }
    }

    //implement methods of the KeyListener
    public void keyPressed(KeyEvent e) {
        //key codes: http://www.cambiaresearch.com/articles/15/javascript-char-codes-key-codes

        if (e.getKeyCode()==38){ //Up Arrow
            player.move(0, -5);
        } else if (e.getKeyCode()==40){ //Down Arrow
            player.move(0, 5);
        } else if(e.getKeyCode() == 32) { // Spacebar
            for(int i = 0; i < projectiles.length; i++) {
                if(!projectiles[i].inMotion()) {
                    projectiles[i].setMotion(true);
                    projectiles[i].reset(75, /* Garbage value, overwritten in next statement */400);
                    projectiles[i].move(0, player.getY() - projectiles[i].getY() + 50);

                    playSound("cannon.wav");

                    return; // We've just set off a projectile, don't set them all off!
                }
            }
        }

        repaint();
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}
