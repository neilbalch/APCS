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

    // Draw in basic stage functionality
    public void drawMe(Graphics g) {
        // Draw in NPCs
        for(NPC npc : npcs) { npc.drawMe(g); }

        // Draw in Items
        for(Item item : items) { item.drawMe(g); }

        // Draw Portals
        g.setColor(new Color(154, 196, 216, 133));
        if(topPortal) g.fillRect(400 - 50, 0, 100, 100);
        if(bottomPortal) g.fillRect(400 - 50, 500, 100, 100);
        if(leftPortal) g.fillRect(0, 300 - 50, 100, 100);
        if(rightPortal) g.fillRect(700, 300 - 50, 100, 100);
    }

    // Add an NPC to the stage
    public void addNPC(NPC npc) { npcs.add(npc); }

    // Add an NPC to the stage
    public void addNPCItem(int i, Item npcItem) { npcs.get(i).addItem(npcItem); }

    // Add an Item to the stage
    public void addItem(Item item) { items.add(item); }

    // Returns whether or not the provided location is within the bounding box provided
    private boolean coordsWithin(Point location, Point topLeft, Point bottomRight) {
        if(location.x > topLeft.x && location.x < bottomRight.x &&
                location.y > topLeft.y && location.y < bottomRight.y) return true;
        else return false;
    }

    // Inform the NPC that the player is within interaction distance with
    public void interactWithNPCs(Point playerLocation) {
        int boundingBoxRadius = 35;

        for(int i = 0; i < npcs.size(); i++) {
            Point npcPos = npcs.get(i).getPosition();
            if(coordsWithin(playerLocation, new Point(npcPos.x - boundingBoxRadius, npcPos.y - boundingBoxRadius), new Point(npcPos.x + boundingBoxRadius, npcPos.y + boundingBoxRadius)))
                npcs.get(i).interact();
        }
    }

    // Returns the item to place in the player's inventory, or null if there is none to add
    public Item interactWithItems(Point playerLocation) {
        int boundingBoxRadius = 25;

        for(int i = 0; i < items.size(); i++) {
            Point itemPos = items.get(i).getPosition();
            if(coordsWithin(playerLocation, new Point(itemPos.x - boundingBoxRadius, itemPos.y - boundingBoxRadius), new Point(itemPos.x + boundingBoxRadius, itemPos.y + boundingBoxRadius))) {
                Item temp = items.get(i);
                items.remove(i);
                return temp;
            }
        }

        return null;
    }

    // Returns whether or not the player has entered a portal, and if so, where they have decided to go.
    // Point(0, o) indicates that no portal was entered.
    public Point portalEntered(Point playerLocation) {
        if(coordsWithin(playerLocation, new Point(400 - 50, 0), new Point(400 + 50, 100))) { // Top
            return new Point(-1, 0);
        } else if(coordsWithin(playerLocation, new Point(400 - 50, 500), new Point(400 + 50, 600))) { // Bottom
            return new Point(1, 0);
        } else if(coordsWithin(playerLocation, new Point(0, 300 - 50), new Point(100, 300 + 50))) { // Left
            return new Point(0, -1);
        } else if(coordsWithin(playerLocation, new Point(700, 300 - 50), new Point(800, 300 + 50))) { // Right
            return new Point (0, 1);
        } else return new Point(0, 0);
    }
}
