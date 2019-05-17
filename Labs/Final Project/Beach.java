import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;
import java.awt.Dimension;

public class Beach extends Stage {
    public Beach(boolean top, boolean bottom, boolean left, boolean right) {
        super(top, bottom, left, right);

        npcs.add(new NPC(new Point(350, 400), "Hello! I'm an NPC. I have a lot to say, and you're going to have to listen to it."));
    }

    @Override
    public void drawMe(Graphics g) {
        // Draw ocean
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, 800, 600);

        { // Draw in beach
            g.setColor(new Color(186, 154, 93));
            int[] x_pts = {0,   0,      400,    500};
            int[] y_pts = {0,   500,    400,    0};
            g.fillPolygon(x_pts, y_pts, x_pts.length);
        }
        { // Draw in inland
            g.setColor(Color.GREEN);
            int[] x_pts = {0,   0,      400};
            int[] y_pts = {0,   300,    0};
            g.fillPolygon(x_pts, y_pts, x_pts.length);
        }

        // Draw in NPCs and portals
        super.drawMe(g);
    }
}
