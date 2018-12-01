import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;

public class Projectile {
    private Dimension location;
    private Dimension size;

    private Color red;

    private boolean inMotion;

    public Projectile(int x, int y){
        this.location = new Dimension(x, y);
        this.size = new Dimension(20, 10);

        this.red = new Color(255,0, 0);
        this.inMotion = false;
    }

    public void setMotion(boolean visiblity) {
        this.inMotion = visiblity;
    }

    public void move(int d_x, int d_y) {
        if(inMotion) {
            this.location.width += d_x;
            this.location.height += d_y;
        }

        if(this.location.width > 800) { // Don't draw if off of the screen
            inMotion = false;
        }
    }

    public void reset(int x, int y) {
        this.location.width = x;
        this.location.height = y;
    }

    public void drawMe(Graphics g){
        if(inMotion) {
            g.setColor(red);
            g.fillRect(location.width - size.width * 2 / 3, location.height, size.width * 3 / 5, size.height);
            g.fillOval(location.width, location.height, size.width / 3, size.height);
        }
    }

    public int getX(){
        return location.width;
    }

    public int getY(){
        return location.height;
    }

    public int getWidth() {
        return size.width;
    }

    public int getHeight() {
        return size.height;
    }

    public boolean inMotion() {
        return inMotion;
    }
}
