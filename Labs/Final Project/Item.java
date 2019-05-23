import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;
import java.awt.Dimension;

public abstract class Item {
    protected Point position;
    private String name;

    public Item(Point position, String name) {
        this.position = position;
        this.name = name;
    }

    public Point getPosition() { return position; }
    public String getName() { return name; }

    public void drawMe(Graphics g) { drawMe(g, position); }
    public abstract void drawMe(Graphics g, Point position);
}
