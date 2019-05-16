import javax.swing.JPanel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Screen extends JPanel implements KeyListener, ActionListener {
//    private Player player;
//    private Target[] asteroids;
//    private Projectile[] projectiles;
//    private AsteroidField asteroidField;
//    private Runnable animationContents;
//    private Thread animationThread;
//    private Button reset;
//    private BufferedImage bgL1;
//    private BufferedImage bgL2;
//
//    // Game State enum Types
//    private enum Level {LEVEL1, LEVEL2}
//    private Level level;
//    private enum GameState {InProgress, WON, LOST}
//    private GameState gameState;
//
//    // State variables
//    private int lastNumHit;
//    private int lives;
//    private boolean deathSoundPlayed;
//    private boolean resetting;

    // State variables
    private Point currentStage;
    private Stage[][] map;
    private int opacity;
    private boolean showHelp;
    private Point playerPosition;

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
        setFocusable(true);
        addKeyListener(this);

        currentStage = new Point(1, 1);
        map = new Stage[3][3];
        map[0][0] = null;
        map[0][1] = null;
        map[0][2] = null;
        map[1][0] = null;
        map[1][1] = new LandingPoint(true, true, true, true);
        map[1][2] = null;
        map[2][0] = null;
        map[2][1] = null;
        map[2][2] = null;
        opacity = 255;
        showHelp = true;
        playerPosition = new Point(400, 300);
    }

    //Sets the size of the panel
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    private void drawHelpMenu(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Calibri", Font.BOLD, 60));
        g.drawString("Help Menu:", 75, 100);
        g.setFont(new Font("Calibri", Font.BOLD, 36));
        g.drawString("\"h\": Show help menu (this screen)", 75, 140);
        g.drawString("\"Up Arrow\": Move player upward", 75, 180);
        g.drawString("\"Down Arrow\": Move player downward", 75, 220);
        g.drawString("\"Left Arrow\": Move player leftward", 75, 260);
        g.drawString("\"Right Arrow\": Move player rightward", 75, 300);
        g.drawString("\"Spacebar\": Interact with NPC or portal", 75, 340);
    }

    private void drawPlayer(Graphics g, Point playerPosition) {
        // Draw Body
        g.setColor(Color.RED);
        int[] x_pts = {playerPosition.x - 10, playerPosition.x, playerPosition.x + 10};
        int[] y_pts = {playerPosition.y + 25, playerPosition.y, playerPosition.y + 25};
        g.fillPolygon(x_pts, y_pts, x_pts.length);

        // Draw Head
        g.setColor(new Color(203, 174, 108));
        g.fillOval(playerPosition.x - 15/2, playerPosition.y - 10, 15, 15);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the stage as a background
        map[currentStage.x][currentStage.y].drawMe(g);

        if (opacity >= 0) { // Game just started, we are fading in from black
            drawHelpMenu(g);
            g.setColor(new Color(0, 0, 0, opacity));
            g.fillRect(0, 0, 800, 600);
            opacity--;

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        } else if(showHelp) { // Show the help menu?
            drawHelpMenu(g);
        } else {
            drawPlayer(g, playerPosition);
        }
    }

    public void keyPressed(KeyEvent e) {
        int moveMagnitude = 5;

        switch(e.getKeyCode()) {
            case 37:    // Left Arrow
                playerPosition.setLocation(playerPosition.getX() - moveMagnitude, playerPosition.getY());
                break;
            case 38:    // Up Arrow
                playerPosition.setLocation(playerPosition.getX(), playerPosition.getY() - moveMagnitude);
                break;
            case 39:    // Right Arrow
                playerPosition.setLocation(playerPosition.getX() + moveMagnitude, playerPosition.getY());
                break;
            case 40:    // Down Arrow
                playerPosition.setLocation(playerPosition.getX(), playerPosition.getY() + moveMagnitude);
                break;
            case 32:    // Spacebar
                Point portal = map[currentStage.x][currentStage.y].portalEntered(playerPosition);
                if(portal.x != 0 || portal.y != 0) { // Which direction did the player want to move?
                   if(portal.x == 1) playerPosition.setLocation(playerPosition.getX() + 1, playerPosition.getY());
                   else if(portal.x == -1) playerPosition.setLocation(playerPosition.getX() - 1, playerPosition.getY());
                   else if(portal.y == 1) playerPosition.setLocation(playerPosition.getX(), playerPosition.getY() + 1);
                   else if(portal.y == -1) playerPosition.setLocation(playerPosition.getX(), playerPosition.getY() - 1);
                } else map[currentStage.x][currentStage.y].interactWithNPCs(playerPosition);
                break;
        }

        repaint();
    }
    public void keyTyped(KeyEvent e) { // Cheat key handled here because we don't want to repeat the keypress accidentally
        //TODO(Neil): Delete this one?
        if(e.getKeyChar() == 'p') {} // Move to level 2 if commanded to
        else if(e.getKeyChar() == 'h') showHelp = !showHelp;

        repaint();
    }
    public void keyReleased(KeyEvent e) {}
    public void actionPerformed(ActionEvent e) { // Handle reset button presses
    }
}
