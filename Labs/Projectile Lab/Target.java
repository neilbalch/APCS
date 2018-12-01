import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;

public class Target {
    private Dimension location;
    private Dimension size;

    private Color color;

    private boolean hit;

    public Target(int x, int y, Color color) {
        this.location = new Dimension(x, y);
        this.size = new Dimension(50, 50);

        this.color = color;
        this.hit = false;
    }

    public void drawMe(Graphics g){
        if(!hit) {
            g.setColor(color);
            g.fillRect(location.width, location.height, size.width, size.height);
        }
    }

    // Check for collision, making enemy disappear if hit by projectile
    public void checkCollision(Projectile p) {
        if(!hit) {
            int p_x1 = p.getX();
            int p_y1 = p.getY();
            int p_x2 = p_x1 + p.getWidth();
            int p_y2 = p_y1 + p.getHeight();

            if (p_x2 >= location.width && p_x1 <= location.width + size.width && p_y2 >= location.height && p_y1 <= location.height + size.height) {
                // Collided
                hit = true;
            }
        }
    }

    public boolean isHit() {
        return hit;
    }

    public void move(int d_x, int d_y) {
        this.location.setSize(this.location.width + d_x, this.location.height + d_y);
    }

    public int getX(){
        return location.width;
    }

    public int getY(){
        return location.height;
    }
}
