import java.awt.Graphics;
import java.awt.Point;
import java.awt.Dimension;
import java.awt.Color;
import java.util.ArrayList;

public abstract class Stage {
    protected boolean topPortal;
    protected boolean bottomPortal;
    protected boolean leftPortal;
    protected boolean rightPortal;
    protected Dimension portalSize;

    protected ArrayList<NPC> npcs;
    protected ArrayList<Item> items;

    public Stage(boolean top, boolean bottom, boolean left, boolean right) {
        this.topPortal = top;
        this.bottomPortal = bottom;
        this.leftPortal = left;
        this.rightPortal = right;
        this.portalSize = new Dimension(50, 25);

        this.npcs = new ArrayList<NPC>();
        this.items = new ArrayList<Item>();
    }

    public void drawMe(Graphics g) {
        // Draw in NPCs
        for(NPC npc : npcs) {
            npc.drawMe(g);
        }

        // Draw Portals
        g.setColor(new Color(154, 196, 216, 133));
        if(topPortal) g.fillRect(400 - 50, 0, 100, 100);
        if(bottomPortal) g.fillRect(400 - 50, 500, 100, 100);
        if(leftPortal) g.fillRect(0, 300 - 50, 100, 100);
        if(rightPortal) g.fillRect(700, 300 - 50, 100, 100);
    }

    // Returns whether or not the provided location is within the bounding box provided
    private boolean coordsWithin(Point location, Point topLeft, Point bottomRight) {
        if(location.x > topLeft.x && location.x < bottomRight.x &&
                location.y > topLeft.y && location.y < bottomRight.y) return true;
        else return false;
    }

    public void interactWithNPCs(Point playerLocation) {
        int boundingBoxRadius = 35;

        for(int i = 0; i < npcs.size(); i++) {
            Point npcPos = npcs.get(i).getPosition();
            if(coordsWithin(playerLocation, new Point(npcPos.x - boundingBoxRadius, npcPos.y - boundingBoxRadius), new Point(npcPos.x + boundingBoxRadius, npcPos.y + boundingBoxRadius)))
                npcs.get(i).interact();
        }
    }

    public Point portalEntered(Point playerLocation) {
        if(coordsWithin(playerLocation, new Point(400 - 50, 0), new Point(400 + 50, 100))) {
            return new Point(0, -1);
        } else if(coordsWithin(playerLocation, new Point(400 - 50, 500), new Point(400 + 50, 600))) {
            return new Point(0, 1);
        } else if(coordsWithin(playerLocation, new Point(0, 300 - 50), new Point(100, 300 + 50))) {
            return new Point(-1, 0);
        } else if(coordsWithin(playerLocation, new Point(700, 300 - 50), new Point(800, 300 + 50))) {
            return new Point (1, 0);
        } else return new Point(0, 0);
    }
}
