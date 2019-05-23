import java.awt.*;

public class Chestplate extends Item {
    public Chestplate(Point position) { super(position, "chestplate"); }

    public void drawMe(Graphics g, Point position) {
        int x = (int)position.getX();
        int y = (int)position.getY();

        g.setColor(new Color(188, 188, 188));
        int[] x_pts = {x - 15, x - 10, x - 10, x + 10, x + 10, x + 15, x + 15, x, x - 15};
        int[] y_pts = {y - 15, y - 15, y - 8, y - 8, y - 15, y - 15, y + 12, y + 15, y + 12};
        g.fillPolygon(x_pts, y_pts, x_pts.length);
    }
}
