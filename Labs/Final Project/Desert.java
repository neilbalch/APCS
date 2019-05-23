import java.awt.*;

public class Desert extends Stage {
    public Desert(boolean top, boolean bottom, boolean left, boolean right) { super(top, bottom, left, right); }

    @Override
    public void drawMe(Graphics g) {
        // Draw landscape
        g.setColor(new Color(222, 219, 76));
        g.fillRect(0, 0, 800, 600);

        // Draw in NPCs and portals
        super.drawMe(g);
    }
}
