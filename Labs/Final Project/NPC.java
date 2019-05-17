import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

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
            int maxCharsPerLine = 30;
            int linesRequired = message.length() / maxCharsPerLine;
            if(message.length() % maxCharsPerLine != 0) linesRequired++;

            // Draw bounding box around speech
            g.setColor(Color.WHITE);
            g.fillRoundRect(position.x + 10, position.y - 15, 180, linesRequired * 20, 15, 15);

            // Draw test in place
            g.setColor(Color.BLACK);
            g.setFont(new Font("Calibri", Font.BOLD, 14));
            int textY = position.y;
            for(int i = 0; i < linesRequired; i++) {
                if(i < linesRequired - 1) g.drawString(message.substring(i * maxCharsPerLine, (i + 1) * maxCharsPerLine), position.x + 15, textY);
                else g.drawString(message.substring(i * maxCharsPerLine), position.x + 15, textY); // Don't provide and endpoint to substring if  it's the last line
                textY += 20;
            }

            // Reset the interactedWith flag
            interactedWith = false;
        }
    }

    public void interact() { this.interactedWith = true; }
}
