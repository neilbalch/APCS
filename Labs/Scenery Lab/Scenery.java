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
    private Color brick = new Color(148, 55, 41);
    private Color river = new Color(33, 92, 148);

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

        // Tree
        drawTree(50, 350, g);

        // Mountain
        Dimension initial = new Dimension(500, 200);
        g.setColor(lightGrey);
        int x_pts[] = {initial.width, initial.width + 100, initial.width + 200};
        int y_pts[] = {initial.height + 250, initial.height, initial.height + 250};
        g.fillPolygon(x_pts, y_pts, x_pts.length);

        g.setColor(Color.white);
        int x_pts2[] = {initial.width + 100 - 20, initial.width + 100, initial.width + 100 + 20};
        int y_pts2[] = {initial.height + 50, initial.height, initial.height + 50};
        g.fillPolygon(x_pts2, y_pts2, x_pts.length);

        // House
        Dimension houseTop = new Dimension(300, 350);
        g.setColor(brick);
        g.fillRect(houseTop.width + 20, houseTop.height + 20, 75, 50);
        g.setColor(Color.GRAY);
        int x_pts3[] = {houseTop.width, houseTop.width + 55, houseTop.width + 110};
        int y_pts3[] = {houseTop.height + 20, houseTop.height, houseTop.height + 20};
        g.fillPolygon(x_pts3, y_pts3, x_pts3.length);

        // River
        g.setColor(river);
        g.fillOval(0, getPreferredSize().height - 20, 150, 30);
        g.fillOval(125, getPreferredSize().height - 30, 150, 30);
        g.fillOval(250, getPreferredSize().height - 40, 150, 30);
        g.fillOval(250 + 125, getPreferredSize().height - 50, 150, 30);
        g.fillOval(250 + 125 * 2, getPreferredSize().height - 60, 150, 30);
        g.fillOval(250 + 125 * 3, getPreferredSize().height - 50, 150, 30);
        g.fillOval(250 + 125 * 4, getPreferredSize().height - 40, 150, 30);

        // Building
        g.setColor(Color.GRAY);
        g.fillRect(200, 250, 75, 250);
        g.setColor(Color.yellow);
        g.fillRect(215, 263, 15, 15);
        g.fillRect(245, 263, 15, 15);
        g.fillRect(215, 263 + 30, 15, 15);
        g.fillRect(245, 263 + 30, 15, 15);
        g.fillRect(215, 263 + 60, 15, 15);
        g.fillRect(245, 263 + 60, 15, 15);
        g.fillRect(215, 263 + 90, 15, 15);
        g.fillRect(245, 263 + 90, 15, 15);
        g.fillRect(215, 263 + 120, 15, 15);
        g.fillRect(245, 263 + 120, 15, 15);
        g.fillRect(215, 263 + 150, 15, 15);
        g.fillRect(245, 263 + 150, 15, 15);
        g.fillRect(215, 263 + 180, 15, 15);
        g.fillRect(245, 263 + 180, 15, 15);
        g.fillRect(215, 263 + 210, 15, 15);
        g.fillRect(245, 263 + 210, 15, 15);
    }
}