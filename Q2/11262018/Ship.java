import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;

public class Ship {
    private Dimension location;
    private Dimension size;
    private Color blue;

    public Ship(int x, int y) {
        this.location = new Dimension(x, y);
        this.size = new Dimension(50, 50);

        this.blue = new Color(0,0,255);
    }


    public void drawMe(Graphics g){
        g.setColor(blue);
        g.fillRect(location.width, location.height, size.width, size.height);
    }

    public void moveUp(){
        this.location.setSize(this.location.width, this.location.height - 5);
    }

    public void moveDown(){
        this.location.setSize(this.location.width, this.location.height + 5);
    }

    public int getX(){
        return location.width;
    }

    public int getY(){
        return location.height;
    }
}