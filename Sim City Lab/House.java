import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;

public class House {
    private static Color brick = new Color(165, 57, 0);
    private static Color roof = new Color(90, 90, 90);
    private static Color windows = new Color(212, 222, 0);
    private static Color door = new Color(100, 60, 42);

    public static void drawHouse(Graphics g, Dimension root) {
        int[] x_pts = {root.width, root.width + 50, root.width + 100};
        int[] y_pts = {root.height + 30, root.height, root.height + 30};
        g.setColor(roof);
        g.fillPolygon(x_pts, y_pts, x_pts.length);

        g.setColor(brick);
        g.fillRect(root.width + 7, root.height + 30, 86, 40);

        g.setColor(windows);
        g.fillRect(root.width + 20, root.height + 35, 22, 22);

        g.setColor(door);
        g.fillRect(root.width + 60, root.height + 35, 20, 35);
    }
}
