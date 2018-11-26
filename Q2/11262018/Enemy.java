import java.awt.Color;
import java.awt.Graphics;

public class Enemy {
    private int x;
    private int y;

    private int width;
    private int height;

    private Color color;

    public Enemy(int x, int y, Color color) {
        this.x = x;
        this.y = y;

        this.width = 50;
        this.height = 50;

        this.color = color;
    }

    public void drawMe(Graphics g){
        g.setColor(color);
        g.fillRect(x,y,width,height);
    }

    public void move(int d_x, int d_y) {
        this.x += d_x;
        this.y += d_y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}
