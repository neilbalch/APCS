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
    private Projectile[] projectiles;
    private int previousNumHit;
    private BufferedImage bgL1;
    private BufferedImage bgL2;
    private AsteroidField asteroidField;
    private enum Level {LEVEL1, LEVEL2}
    private Level level;
    private int lives;
    private Button reset;
    private enum GameState {InProgress, WON, LOST}
    private GameState gameState;
    private boolean deathSoundPlayed;
    private boolean resetInProgress;
    private Runnable animationContents;
    private Thread animationThread;

    private double simTimeScalar = 1; // Makes the game run faster for testing purposes. Ludicrously unplayable if >5.

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
        System.out.println("Hi! Why are you looking at the console output? You should be grading!");

        // Organize the reset button
        reset = new Button("Reset");
        reset.setBounds(10, 50, 50, 25);
        add(reset);
        reset.addActionListener(this);

        //sets keylistener
        setFocusable(true);
        addKeyListener(this);

        // Organize the animation thread that reanimates the JPanel
        animationContents = new Runnable() {
            @Override
            public void run() {
                while(true) {
                    //wait for .01 second
                    try {
                        Thread.sleep((int)(10 / simTimeScalar));
                        if(!resetInProgress) animate();
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        };
        animationThread = new Thread(animationContents);
        asteroidField = new AsteroidField();

        // Try read images
        try {
            bgL1 = ImageIO.read(new File("sun.jpg"));
            bgL2 = ImageIO.read(new File("jupiter.jpg"));
        } catch (IOException ex) {} // handle exception...

        // Start off with the first level
        resetLevel(Level.LEVEL1);
    }

    private void resetLevel(Level level) {
        // Stop Animation so it doesn't interfere
        animationThread.interrupt();
        animationThread = null;
        resetInProgress = true;

        // Do the level change, if called for
        this.level = level;

        player = new Player(50, 300);

        // Level 1 gets 10 targets, Level 2 gets 20
        asteroids = new Target[level == Level.LEVEL1 ? 10 : 20];
        for(int i = 0; i < asteroids.length; i++) asteroids[i] = new Target((int)(400 * Math.random() + 400), (int)(500 * Math.random()));

        if(lives == 0) lives = 3;
        else if(lives <= 3 && lives > 0) {} // Don't touch the lives, must keep the value

        projectiles = new Projectile[3];
        for(int i = 0; i < projectiles.length; i++) {
            projectiles[i] = new Projectile(75, 350);
        }
        previousNumHit = 0;
        gameState = GameState.InProgress;
        deathSoundPlayed = false;

        // Restart animation
        animationThread = new Thread(animationContents);
        animationThread.start();
        addKeyListener(this);
        resetInProgress = false;
    }

    public Dimension getPreferredSize() {
        //Sets the size of the panel
        return new Dimension(800, 600);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        switch(gameState) { // Draw loop
            case LOST:
                g.setColor(Color.BLACK);
                g.setFont(new Font("Calibri", Font.BOLD, 72));
                g.drawString("You Lose!", 250, 300);
                g.setFont(new Font("Calibri", Font.PLAIN, 24));
                g.drawString("Tap \"Reset\" to start anew.", 250, 350);
                break;
            case WON:
                g.setColor(Color.BLACK);
                g.setFont(new Font("Calibri", Font.BOLD, 72));
                g.drawString("You Win, Nice Job!", 225, 300);
                g.setFont(new Font("Calibri", Font.PLAIN, 24));
                g.drawString("Tap \"Reset\" to start anew.", 250, 350);
                break;
            default:
                // Draw BG
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, 800, 600);
                g.drawImage(level == Level.LEVEL1 ? bgL1 : bgL2, 0, 0, 400, 600, this);

                // Draw asteroid field and player
                asteroidField.drawAsteroids(g, this);
                player.drawMe(g, this);

                //Draw Projectile
                for(int i = 0; i < projectiles.length; i++) projectiles[i].drawMe(g);

                // Display num targets hit
                int numHit = 0;
                for(int i = 0; i < asteroids.length; i++) {
                    if(asteroids[i] != null) { // Avoids possible nullpointer exceptions
                        asteroids[i].drawMe(g, null);
                        if (asteroids[i].isHit()) numHit++;
                    }
                }

                // Play a sound per new target hit
                for(int i = 0; i < numHit - previousNumHit; i++) playSound("hit.wav");
                previousNumHit = numHit; // reset the variable for the next iteration

                // Draw stats and progress @ top
                g.setColor(Color.WHITE);
                g.setFont(new Font("Arial", Font.PLAIN, 18));
                g.drawString(numHit == asteroids.length ? "All asteroids are hit!" : "Number of Targets Hit: " + numHit, 10, 25);
                g.drawString("Level: " + (level.equals(Level.LEVEL1) ? "1" : "2"), 700, 25);
                g.drawString("Lives: " + lives, 700, 50);
            break;
        }
    }

    private void animate() {
        // Projectile motion and collision detection
        for(int i = 0; i < projectiles.length; i++) {
            projectiles[i].move(3, 0);
            for(int j = 0; j < asteroids.length; j++) asteroids[j].checkProjectileCollision(projectiles[i]);
        }

        // Asteroid motion and collision detection
        int livesTakenThisIteration = 0;
        for(int i = 0; i < asteroids.length; i++) {
            // Select random motion of asteroids
            switch((int)(50 * Math.random())) {
                case 1: // Move Left
                    // Asteroids move 4px/move faster in level 2
                    asteroids[i].transpose(level == Level.LEVEL1 ? -6 : -10, 0);
                    break;
                case 2: // Move Up
                    if(asteroids[i].getY() >= 25)// Jump it if it's near the top edge
                        asteroids[i].transpose(0, -2);
                    break;
                case 3: // Move Down
                    if(asteroids[i].getY() <= 550) // Jump it if it's near the bottom edge
                        asteroids[i].transpose(0, 2);
                    break;
                default: // Don't transpose
                    break;
            }

            // If current asteroid reached the end or if current asteroid has collided with the player...
            if(asteroids[i].getX() <= 0 && !asteroids[i].hasTriggeredLossOfLife() ||
               asteroids[i].checkPlayerCollision(player) && !asteroids[i].hasTriggeredLossOfLife()) {
                if(lives != 0) lives--;
                livesTakenThisIteration++;
                asteroids[i].setTriggeredLossOfLife();
            }
        }

        // End the game if 0 life is reached
        if(lives <= 0) {
            if(!deathSoundPlayed) {
                playSound("death.wav");
                deathSoundPlayed = true;
            }
            gameState = GameState.LOST;
        } else {
            // Restart the level if a life is lost
            if(livesTakenThisIteration > 0) resetLevel(level);

            // If all asteroids in given level are hit...
            if(previousNumHit == asteroids.length) {
                if(level == Level.LEVEL1) resetLevel(Level.LEVEL2); // Move to Level 2 if all asteroids are gone
                else { // Game is won, player got past 2nd level
                    animationThread.interrupt(); // Kill the animation thread
                    gameState = GameState.WON;
                }
            }
        }

        //repaint the graphics drawn
        repaint();
    }

    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case 38:                                                // Up Arrow
                if(player.getY() > 0) player.move(0, -5);
                break;
            case 40:                                                // Down Arrow
                if(player.getY() < (600 - player.getHeight())) player.move(0, 5);
                break;
            case 32:                                                // Spacebar
                for (int i = 0; i < projectiles.length; i++) {
                    if (!projectiles[i].inMotion()) {
                        projectiles[i].setMotion(true);
                        projectiles[i].reset(75, /* Garbage value, overwritten in next statement */400);
                        projectiles[i].move(0, player.getY() - projectiles[i].getY() + (int) (0.5 * player.getHeight() - 10));

                        playSound("cannon.wav");

                        return; // We've just set off a projectile, don't set them all off!
                    }
                }
                break;
        }

        if(gameState == GameState.InProgress) repaint();
    }
    public void keyTyped(KeyEvent e) { // Cheat key handled here because we don't want to repeat the keypress accidentally
        if(e.getKeyChar() == 'p' && level != Level.LEVEL2) resetLevel(Level.LEVEL2); // Move to level 2 if commanded to
    }
    public void keyReleased(KeyEvent e) {}
    public void actionPerformed(ActionEvent e) { // Handle reset button presses
        if(e.getSource().equals(reset)) {
            // Remove focus from button
            reset.transferFocus();

            resetLevel(Level.LEVEL1);
        }
    }
}
