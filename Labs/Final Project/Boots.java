import java.awt.*;

public class Boots extends Item {
    public Boots(Point position) { super(position, "boots"); }

    public void drawMe(Graphics g, Point position) {
        int x = (int)position.getX();
        int y = (int)position.getY();

        g.setColor(new Color(188, 188, 188));
        {
            int[] x_pts = {x - 15, x - 9, x - 9, x - 5, x - 5, x - 15};
            int[] y_pts = {y - 15, y - 15, y + 10, y + 10, y + 15, y + 15};
            g.fillPolygon(x_pts, y_pts, x_pts.length);
        }
        {
            int[] x_pts = {x + 5, x + 11, x + 11, x + 15, x + 15, x + 5};
            int[] y_pts = {y - 15, y - 15, y + 10, y + 10, y + 15, y + 15};
            g.fillPolygon(x_pts, y_pts, x_pts.length);
        }
    }
}
