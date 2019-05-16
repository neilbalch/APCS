import java.awt.Graphics;
import java.awt.Point;
import java.awt.Dimension;

public abstract class Stage {
    protected boolean topPortal;
    protected boolean bottomPortal;
    protected boolean leftPortal;
    protected boolean rightPortal;
    protected Dimension portalSize;

    public Stage(boolean top, boolean bottom, boolean left, boolean right) {
        this.topPortal = top;
        this.bottomPortal = bottom;
        this.leftPortal = left;
        this.rightPortal = right;
        this.portalSize = new Dimension(50, 25);
    }

    public abstract void drawMe(Graphics g);
    public abstract void interactWithNPCs(Point playerLocation);

    // Returns whether or not the provided location is within the bounding box provided
    private boolean coordsWithin(Point location, Point topLeft, Point bottomRight) {
        if(location.x > topLeft.x && location.x < bottomRight.x &&
                location.y > topLeft.y && location.y < bottomRight.y) return true;
        else return false;
    }

    public Point portalEntered(Point playerLocation) {
        //TODO(Neil): Write this!!
        return new Point(0, 0);
    }
}
