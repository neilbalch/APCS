import java.awt.*;

public class Savannah extends Stage {
    public Savannah(boolean top, boolean bottom, boolean left, boolean right) { super(top, bottom, left, right); }

    @Override
    public void drawMe(Graphics g) {
        // Draw landscape
        g.setColor(new Color(152, 173, 101));
        g.fillRect(0, 0, 800, 600);

        // Draw in NPCs and portals
        super.drawMe(g);
    }
}
