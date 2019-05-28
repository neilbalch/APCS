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

    // Returns whether or not the provided location is within the bounding box provided
    private boolean coordsWithin(Point location, Point topLeft, Point bottomRight) {
        if(location.x > topLeft.x && location.x < bottomRight.x &&
                location.y > topLeft.y && location.y < bottomRight.y) return true;
        else return false;
    }


    public void interact(Point playerPosition, boolean swordEquipped) {
        super.interact();
        Point bottomRight = (Point)getPosition().clone();
        bottomRight.translate(200, 200);

        if(coordsWithin(playerPosition, getPosition(), bottomRight) && swordEquipped) health -= 5;
        if(defeated()) alive = false;
    }
    public boolean defeated() { return health == 0; }

    public boolean isAlive() { return alive; }

    public void drawMe(Graphics g) {
        if(defeated()) return;

        g.drawImage(bg, super.getPosition().x, super.getPosition().y, 200, 200, null);

        g.setColor(Color.BLACK);
        g.fillRect(getPosition().x, getPosition().y - 10, 100, 5);
        g.setColor(Color.RED);
        g.fillRect(getPosition().x, getPosition().y - 10, health, 5);

        if(isInteractedWith()) resetInteract();
    }
}
