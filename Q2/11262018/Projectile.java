import java.awt.Color;
import java.awt.Graphics;

public class Projectile {
    private int x;
    private int y;

    private int width;
    private int height;

    private Color red;

    private boolean visible;

    public Projectile(int x, int y){
        this.x = x;
        this.y = y;
        this.width = 10;
        this.height = 10;
        this.red = new Color(255,0, 0);
        this.visible = false;
    }

    public void setVisiblity(boolean visiblity) {
        this.visible = visiblity;
    }

    public void move(int d_x, int d_y) {
        if(visible) {
            this.x += d_x;
            this.y += d_y;
        }

        if(x > 800) { // Don't draw if off of the screen
            visible = false;
        }
    }

    public void reset(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void drawMe(Graphics g){
        if(visible) {
            g.setColor(red);
            g.fillOval(x, y, width, height);
        }
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public boolean getVisibility() {
        return visible;
    }
}