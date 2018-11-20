import java.awt.Color;
import java.awt.Graphics;

public class Player {
    // Player position
    private int x;
    private int y;

    private int width;
    private int height;

    private Color blue;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;

        width = 50;
        height = 50;

        blue = new Color(0, 0, 228);
    }

    public void drawPlayer(Graphics g) {
        g.setColor(blue);
        g.fillRect(x, y, width, height);
    }

    public void movePlayer(int d_x, int d_y) {
        x += d_x;
        y -= d_y;
    }
}