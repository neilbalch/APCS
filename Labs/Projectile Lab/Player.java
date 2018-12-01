import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;

public class Player {
    private Dimension location;
    private Dimension size;
    private Color blue;
    private Color skin;

    public Player(int x, int y) {
        this.location = new Dimension(x, y);
        this.size = new Dimension(50, 50);

        this.blue = new Color(0,0,255);
        this.skin = new Color(162, 162, 113);
    }


    public void drawMe(Graphics g){
        g.setColor(skin);
        g.fillOval(location.width, location.height, size.width, size.height);
        g.setColor(blue);
        g.fillRect(location.width, location.height + size.height, size.width, (int)(size.height * 1.5));
    }

    public void move(int d_x, int d_y) {
        this.location.width += d_x;
        this.location.height += d_y;
    }

    public int getX(){
        return location.width;
    }

    public int getY(){
        return location.height;
    }
}
