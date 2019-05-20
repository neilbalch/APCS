import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;
import java.awt.Dimension;

public abstract class Item {
    protected Point position;

    public Item(Point position) { this.position = position; }

    public Point getPosition() { return position; }

    public void drawMe(Graphics g) { drawMe(g, position); }
    public abstract void drawMe(Graphics g, Point position);
}
