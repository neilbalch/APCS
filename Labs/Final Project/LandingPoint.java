import java.awt.*;

public class LandingPoint extends Stage {
    public LandingPoint(boolean top, boolean bottom, boolean left, boolean right) {
        super(top, bottom, left, right);
    }

    public void drawMe(Graphics g) {
        // Draw landscape
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, 800, 600);

        // Draw Portals
        g.setColor(new Color(154, 196, 216, 133));
        if(topPortal) {
            g.fillRect(400 - 50, 0, 100, 100);
        }
        if(bottomPortal) {
            g.fillRect(400 - 50, 500, 100, 100);
        }
        if(leftPortal) {
            g.fillRect(0, 300 - 50, 100, 100);
        }
        if(rightPortal) {
            g.fillRect(700, 300 - 50, 100, 100);
        }
    }

    public void interactWithNPCs(Point playerLocation) {

    }
}
