import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;

public class Mountain {
    private Color mountain = new Color(132, 139, 128);
    private Color cap = new Color(208, 219, 202);

    public void drawMountain(Graphics g, Dimension root, boolean snowy) {
        int[] mtn_x_pts = {root.width,          root.width + 50,    root.width + 100};
        int[] mtn_y_pts = {root.height + 150,   root.height,        root.height + 150};
        g.setColor(snowy ? cap : mountain);
        g.fillPolygon(mtn_x_pts, mtn_y_pts, mtn_x_pts.length);

        int[] cap_x_pts = {root.width + 40,    root.width + 50,    root.width + 60};
        int[] cap_y_pts = {root.height + 30,   root.height,        root.height + 30};
        g.setColor(cap);
        g.fillPolygon(cap_x_pts, cap_y_pts, cap_x_pts.length);
    }
}
