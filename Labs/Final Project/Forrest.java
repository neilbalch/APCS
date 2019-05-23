import java.awt.*;

public class Forrest extends Stage {
    private static Color leaves = new Color(34, 203, 0);
    private static Color bark = new Color(108, 54, 0);
    private Point[] trees;

    public Forrest(boolean top, boolean bottom, boolean left, boolean right) {
        super(top, bottom, left, right);
        trees = new Point[15];
        for(int i = 0; i < trees.length; i++) {
            trees[i] = new Point((int)(Math.random() * 300) + 150, (int)(Math.random() * 100) + 125);
        }
    }

    @Override
    public void drawMe(Graphics g) {
        // Draw landscape
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, 800, 600);

        // Draw Trees
        for(int i = 0; i < trees.length; i++) {
            g.setColor(bark);
            g.fillRect(trees[i].x + 20, trees[i].y + 10, 7, 30);

            g.setColor(leaves);
            g.fillOval(trees[i].x, trees[i].y, 30, 25);
            g.fillOval(trees[i].x + 25, trees[i].y - 5, 30, 25);
        }

        // Draw in NPCs and portals
        super.drawMe(g);
    }
}
