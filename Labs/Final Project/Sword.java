import java.awt.*;

public class Sword extends Item {
    public Sword(Point position) { super(position); }

    public void drawMe(Graphics g, Point position) {
        g.setColor(new Color(135, 187, 187));
        int x = (int)position.getX();
        int y = (int)position.getY();

        int[] x_pts = {x + 10, x + 15, x + 15, x - 5, x - 7, x - 13, x - 15, x - 9, x - 8};
        int[] y_pts = {y - 15, y - 15, y - 10, y + 5, y + 7, y + 15, y + 13, y + 3, y + 3};
        g.fillPolygon(x_pts, y_pts, x_pts.length);
    }
}
