import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class LizardKing extends NPC {
    private BufferedImage bg;
    private boolean alive;
    private int health;

    public LizardKing(Point position, String message, String name) {
        super(position, message, name);
        // Import BG image.
        try {
            bg = ImageIO.read(new File("./boss.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.alive = true;
        this.health = 100;
    }

    public boolean isAlive() { return alive; }

    public void drawMe(Graphics g) {
        g.drawImage(bg, super.getPosition().x, super.getPosition().y, 200, 200, null);
    }
}
