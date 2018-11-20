import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;

public class Foliage {
    private static Color grass = new Color(27, 140, 0);
    private static Color leaves = new Color(34, 203, 0);
    private static Color bark = new Color(108, 54, 0);

    private static void drawTree(Graphics g, Dimension root) {
        g.setColor(bark);
        g.fillRect(root.width + 20, root.height + 10, 7, 30);

        g.setColor(leaves);
        g.fillOval(root.width, root.height, 30, 25);
        g.fillOval(root.width + 25, root.height - 5, 30, 25);
    }

    public static void drawPark(Graphics g, Dimension root) {
        g.setColor(grass);
        g.fillRect(root.width, root.height, 75, 75);

        drawTree(g, new Dimension(root.width + 5, root.height - 15));
        drawTree(g, new Dimension(root.width + 25, root.height + 15));
    }
}
