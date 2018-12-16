import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.image.ImageObserver;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Target {
    private Dimension location;
    private Dimension size;

    private boolean hit;
    private boolean triggeredLossOfLife;
    private BufferedImage image;

    public Target(int x, int y) {
        this.location = new Dimension(x, y);
        this.size = new Dimension(50, 50);

        this.hit = false;
        this.triggeredLossOfLife = false;

        try {
            image = ImageIO.read(new File("asteroid.png"));
        } catch (IOException ex) {
            // handle exception...
        }
    }

    public void drawMe(Graphics g, ImageObserver i){
        if(!hit) {
            g.drawImage(image, location.width, location.height, size.width, size.height, i);
        }
    }

    // Check for collision, making enemy disappear if hit by projectile
    public boolean checkProjectileCollision(Projectile p) {
        if(!hit) {
            int p_x1 = p.getX();
            int p_y1 = p.getY();
            int p_x2 = p_x1 + p.getWidth();
            int p_y2 = p_y1 + p.getHeight();

            if (p_x2 >= location.width && p_x1 <= location.width + size.width && p_y2 >= location.height && p_y1 <= location.height + size.height) {
                // Collided
                hit = true;
                return true;
            }
        }

        return false;
    }

    // Check for collision, making enemy disappear if hit by projectile
    public boolean checkPlayerCollision(Player p) {
        if(!hit) {
            int p_x1 = p.getX();
            int p_y1 = p.getY();
            int p_x2 = p_x1 + p.getWidth();
            int p_y2 = p_y1 + p.getHeight();

            if (p_x2 >= location.width && p_x1 <= location.width + size.width && p_y2 >= location.height && p_y1 <= location.height + size.height) {
                // Collided
                hit = true;
                return true;
            }
        }

        return false;
    }

    public boolean isHit() {
        return hit;
    }

    public void transpose(int d_x, int d_y) {
        this.location.setSize(this.location.width + d_x, this.location.height + d_y);
    }

    public void move(int x, int y) {
        this.location.setSize(x, y);
    }

    public int getX(){
        return location.width;
    }

    public int getY(){
        return location.height;
    }

    public void setTriggeredLossOfLife() { triggeredLossOfLife = true; }

    public boolean hasTriggeredLossOfLife() { return triggeredLossOfLife; }
}
