import javax.swing.JPanel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Screen extends JPanel implements KeyListener, ActionListener {
    private Player player;
    private Target[] asteroids;
    private Projectile projectile;
    private int previousNumHit;
    private BufferedImage sun;

    private enum Level {LEVEL1, LEVEL2};
    private Level level;
    private int lives;
    private Button reset;
    private Runnable animationContents;
    private Thread animationThread;

    private void playSound(String url) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(this.getClass().getClassLoader().getResource(url)));
            clip.start();
            //System.out.println("playing... " + url);
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }

    public Screen() {
        setLayout(null);

        reset = new Button("Reset");
        reset.setBounds(10, 50, 50, 25);
        add(reset);
        reset.addActionListener(this);

        //sets keylistener
        setFocusable(true);
        addKeyListener(this);

        animationContents = new Runnable() {
            @Override
            public void run() {
                while(true) {
                    //wait for .01 second
                    try {
                        Thread.sleep(10);
                        animate();
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        };
        animationThread = new Thread(animationContents);

        try {
            sun = ImageIO.read(new File("sun.jpg"));
        } catch (IOException ex) {
            // handle exception...
        }

        level = Level.LEVEL1;
        resetFrame(level);
    }

    private void resetFrame(Level level) {
        // Stop Animation so it doesn't interfere
        animationThread.interrupt();
        animationThread = null;

        player = new Player(50, 300);

        asteroids = new Target[20];
        for(int i = 0; i < asteroids.length; i++) {
            if(i%3 == 0)
                asteroids[i] = new Target((int)(400 * Math.random() + 400), (int)(500 * Math.random()), new Color(247, 54, 33));
            if(i%3 == 1)
                asteroids[i] = new Target((int)(400 * Math.random() + 400), (int)(500 * Math.random()), new Color(7, 255, 0));
            if(i%3 == 2)
                asteroids[i] = new Target((int)(400 * Math.random() + 400), (int)(500 * Math.random()), new Color(148, 35, 255));
        }

        projectile = new Projectile(0,0);
        previousNumHit = 0;
        lives = 3;

        // Restart animation
        animationThread = new Thread(animationContents);
        animationThread.start();
        addKeyListener(this);
    }

    public Dimension getPreferredSize() {
        //Sets the size of the panel
        return new Dimension(800, 600);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw BG
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 800, 600);
        g.drawImage(sun, 0, 0, 400, 600, this);

        //Draw player
        player.drawMe(g, this);

        int numHit = 0;
        for(int i = 0; i < asteroids.length; i++) {
            asteroids[i].drawMe(g, this);
            if(asteroids[i].isHit()) {
                numHit++;
            }
        }
        for(int i = 0; i < numHit - previousNumHit; i++) {
            playSound("hit.wav");
        }
        previousNumHit = numHit;

        //Draw Projectile
        projectile.drawMe(g);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 18));
        g.drawString(numHit == asteroids.length ? "All asteroids are hit!" : "Number of Targets Hit: " + numHit, 10, 25);
        g.drawString("Level: " + (level.equals(Level.LEVEL1) ? "1" : "2"), 700, 25);
        g.drawString("Lives: " + lives, 700, 50);
    }

    public void animate() {
        // Projectile motion and collision detection
        projectile.move(3, 0);
        for(int j = 0; j < asteroids.length; j++)
            asteroids[j].checkProjectileCollision(projectile);

        // Asteroid motion and collision detection
        for(int i = 0; i < asteroids.length; i++) {
            switch((int)(50 * Math.random())) { // Select random motion of asteroids
                case 1: // Move Left
                    asteroids[i].transpose(-6, 0);
                    break;
                case 2: // Move Right
                    if(asteroids[i].getX() <= 750) { // Don't let it transpose if it's near the right edge
                        asteroids[i].transpose(3, 0);
                    }
                    break;
                case 3: // Move Up
                    if(asteroids[i].getY() >= 25)// Jump it if it's near the top edge
                        asteroids[i].transpose(0, -3);
                    break;
                case 4: // Move Down
                    if(asteroids[i].getY() <= 550) // Jump it if it's near the bottom edge
                        asteroids[i].transpose(0, 3);
                    break;
                default: // Don't transpose
                    break;
            }

            if(asteroids[i].getX() <= 0) { // Asteroid reached the end...
                lives -= 1;
            }

            if(asteroids[i].checkProjectileCollision(player)) {
                lives -= 1;
            }
        }

        //repaint the graphics drawn
        repaint();
    }

    //implement methods of the KeyListener
    public void keyPressed(KeyEvent e) {
        //key codes: http://www.cambiaresearch.com/articles/15/javascript-char-codes-key-codes

        if (e.getKeyCode()==38){ //Up Arrow
            player.move(0, -5);
        } else if (e.getKeyCode()==40){ //Down Arrow
            player.move(0, 5);
        } else if(e.getKeyCode() == 32) { // Spacebar
            if(!projectile.inMotion()) {
                projectile.setMotion(true);
                projectile.reset(75, /* Garbage value, overwritten in next statement */400);
                projectile.move(0, player.getY() - projectile.getY() + (int)(0.5 * player.getHeight() - 10));

                playSound("cannon.wav");

                return; // We've just set off a projectile, don't set them all off!
            }
        }

        repaint();
    }
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(reset)) {
            resetFrame(level);

            // Remove focus from button
            reset.transferFocus();
        }
    }
}

