import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;
import java.awt.Dimension;

public class Emerald extends Item {
    public Emerald(Point position) { super(position, "emerald"); }

    public void drawMe(Graphics g, Point position) {
        g.setColor(new Color(15, 124, 0));
        int[] x_pts = {(int)position.getX() - 10, (int)position.getX(), (int)position.getX() + 10, (int)position.getX()};
        int[] y_pts = {(int)position.getY(), (int)position.getY() - 18, (int)position.getY(), (int)position.getY() + 18};
        g.fillPolygon(x_pts, y_pts, x_pts.length);
    }
}
