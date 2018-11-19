import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;


public class Tree {
    private Color bark = new Color(101, 49, 20);
    private Color leaves = new Color(47, 174, 27);
    private Color fallLeaves = new Color(174, 108, 34);

    private int leavesPosition = 0;

    public void drawTree(Graphics g, Dimension root, boolean winter, boolean autumn) {
        g.setColor(bark);
        g.fillRect(root.width + 25, root.height + 10, 15, 75);

        if(!winter) {
            if(autumn) {
                g.setColor(fallLeaves);
                g.fillOval(root.width, root.height + leavesPosition, 5, 10);
                g.fillOval(root.width + 15, root.height - 5 + leavesPosition, 5, 10);
                g.fillOval(root.width + 30, root.height - 7 + leavesPosition, 5, 10);
                leavesPosition += 2;
            } else {
                leavesPosition = 0;
                g.setColor(leaves);
            }
            g.fillOval(root.width, root.height, 40, 25);
            g.fillOval(root.width + 30, root.height + 5, 40, 25);
        }
    }
}
