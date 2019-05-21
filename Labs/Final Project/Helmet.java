import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;
import java.awt.Dimension;

public class Helmet extends Item {
    public Helmet(Point position) { super(position); }

    public void drawMe(Graphics g, Point position) {
        int x = (int)position.getX();
        int y = (int)position.getY();

        g.setColor(new Color(188, 188, 188));
        int[] x_pts = {x - 15, x - 15, x + 15, x + 15, x + 10, x + 10, x - 10, x - 10};
        int[] y_pts = {y + 15, y - 15, y - 15, y + 15, y + 15, y, y, y + 15};
        g.fillPolygon(x_pts, y_pts, x_pts.length);
    }
}
