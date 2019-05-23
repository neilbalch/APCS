import java.awt.*;

public class Shield extends Item {
    public Shield(Point position) { super(position, "shield"); }

    public void drawMe(Graphics g, Point position) {
        int x = (int)position.getX();
        int y = (int)position.getY();

        g.setColor(new Color(188, 188, 188));
        int[] x_pts = {x - 7, x + 7, x + 10, x + 10, x, x - 10, x - 10};
        int[] y_pts = {y - 15, y - 15, y - 5, y, y + 15, y, y - 5};
        g.fillPolygon(x_pts, y_pts, x_pts.length);
    }
}
