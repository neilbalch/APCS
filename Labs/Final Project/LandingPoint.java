import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;
import java.awt.Dimension;

public class LandingPoint extends Stage {
    public LandingPoint(boolean top, boolean bottom, boolean left, boolean right) { super(top, bottom, left, right); }

    @Override
    public void drawMe(Graphics g) {
        // Draw landscape
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, 800, 600);

        // Draw in NPCs and portals
        super.drawMe(g);
    }
}
