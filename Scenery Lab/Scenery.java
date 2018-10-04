import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;

public class Scenery extends JPanel {
    private boolean night;
    private boolean clouds;

    private Color lightBlue = new Color(108, 206, 209);
    private Color black = new Color(24, 42, 132);
    private Color brown = new Color(153, 92, 28);
    private Color darkBrown = new Color(102, 57, 23);
    private Color cloud = new Color(192, 192, 192, (int)(255*0.75));
    private Color lightGrey = new Color(148, 148, 148);

    private void drawCloud(int x, int y, Graphics g) {
        g.fillOval(x, y + 25, 150, 50);
        g.fillOval(x + 30, y, 150, 50);
        g.fillOval(x + 40, y + 30, 150, 50);
    }

    private void drawTree(int x, int y, Graphics g) {
        g.setColor(darkBrown);
        g.fillRect(x + (int)(75/2 - 7), y + 20, 15, 100);
        g.setColor(Color.green);
        g.fillOval(x, y, 75, 50);
    }

    public Scenery(boolean night, boolean clouds) {
        this.night = night;
        this.clouds = clouds;
    }

    public Dimension getPreferredSize() {
        return new Dimension(800,600);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // BG
        g.setColor(night ? black : lightBlue);
        g.fillRect(0, 0, getPreferredSize().width, getPreferredSize().height);

        // FG
        g.setColor(brown);
        g.fillRect(0, getPreferredSize().height / 2, getPreferredSize().width, getPreferredSize().height / 2);

        // Sun
        if(!night) {
            g.setColor(Color.yellow);
            g.fillOval(25, 25, 100, 100);
        }

        // Clouds
        if(clouds) {
            g.setColor(cloud);
            drawCloud(50, 90, g);
            drawCloud(250, 75, g);
            drawCloud(400, 100, g);
            drawCloud(600, 85, g);
        }

        drawTree(50, 350, g);

        Dimension initial = new Dimension(500, 200);
        g.setColor(lightGrey);
        int x_pts[] = {initial.width, initial.width + 100, initial.width + 200};
        int y_pts[] = {initial.height + 250, initial.height, initial.height + 250};
        g.fillPolygon(x_pts, y_pts, x_pts.length);

        g.setColor(Color.white);
        int x_pts2[] = {initial.width + 100 - 20, initial.width + 100, initial.width + 100 + 20};
        int y_pts2[] = {initial.height + 50, initial.height, initial.height + 50};
        g.fillPolygon(x_pts2, y_pts2, x_pts.length);
    }
}