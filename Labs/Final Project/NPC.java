import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

public class NPC {
    private String message;
    private String name;
    private Point position;
    private boolean interactedWith;

    private Color[] colors;
    private int npcColor;

    private ArrayList<Item> items;

    public NPC(Point position, String message, String name) {
        this.position = position;
        this.message = message;
        this.name = name;
        this.interactedWith = false;

        this.colors = new Color[7];
        this.colors[0] = Color.RED;
        this.colors[1] = Color.CYAN;
        this.colors[2] = Color.GRAY;
        this.colors[3] = Color.MAGENTA;
        this.colors[4] = Color.ORANGE;
        this.colors[5] = Color.WHITE;
        this.colors[6] = Color.YELLOW;

        npcColor = (int)(colors.length * Math.random());

        items = new ArrayList<Item>();
    }

    // Add an Item to the stage
    public void addItem(Item item) { this.items.add(item); }
    public Item removeFirstItem() {
        if(items.size() > 0) return this.items.remove(0);
        else return null;
    }
    public boolean noMoreItems() { return this.items.size() == 0; }
    public Point getPosition() { return this.position; }
    public void interact() { this.interactedWith = true; }
    public void resetInteract() { this.interactedWith = false; }
    public boolean isInteractedWith() { return interactedWith; }
    public String getName() { return name; }

    public void drawMe(Graphics g) {
        // Draw body
        g.setColor(colors[npcColor]);
        g.fillRect(position.x - 3, position.y, 6, 15);

        // Draw Head
        g.setColor(new Color(203, 174, 108));
        g.fillOval(position.x - 15/2 - 1, position.y - 10, 15, 15);

        // Are we being talked to?
        if(interactedWith) {
            int maxCharsPerLine = 30;
            int linesRequired = message.length() / maxCharsPerLine;
            if(message.length() % maxCharsPerLine != 0) linesRequired++;

            // Draw bounding box around speech
            g.setColor(Color.WHITE);
            g.fillRoundRect(position.x + 10, position.y - 15, 180, ((linesRequired * 20) + (items.size() > 0 ? 50 : 0)), 15, 15);

            // Draw test in place
            g.setColor(Color.BLACK);
            g.setFont(new Font("Calibri", Font.BOLD, 14));
            int textY = position.y;
            for(int i = 0; i < linesRequired; i++) {
                if(i < linesRequired - 1) g.drawString(message.substring(i * maxCharsPerLine, (i + 1) * maxCharsPerLine), position.x + 15, textY);
                else g.drawString(message.substring(i * maxCharsPerLine), position.x + 15, textY); // Don't provide and endpoint to substring if  it's the last line
                textY += 20;
            }

            // Draw items
            for(int i = 0; i < items.size(); i++) items.get(i).drawMe(g, new Point(position.x + 25 + i * 40, textY + 10));
        }
    }
}
