import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;
import java.awt.Dimension;

public class NPC {
    private String message;
    private Point position;
    private boolean interactedWith;

    private Color[] colors;
    private int npcColor;

    public NPC(Point position, String message) {
        this.position = position;
        this.message = message;
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
    }

    public Point getPosition() { return position; }

    public void drawMe(Graphics g) {
        // Draw NPC
        // Draw body
        g.setColor(colors[npcColor]);
        g.fillRect(position.x - 3, position.y, 6, 15);

        // Draw Head
        g.setColor(new Color(203, 174, 108));
        g.fillOval(position.x - 15/2, position.y - 10, 15, 15);

        // Are we being talked to?
        if(interactedWith) {
            //TODO(NEil): write this
        }
    }

    public void interact() { this.interactedWith = true;
        System.out.println("Interacted with");}
}
