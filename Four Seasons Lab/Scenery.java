import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

public class Scenery extends JPanel {
    private Color lightBlue = new Color(89, 171, 174);
    private Color black = new Color(24, 42, 132);
    private Color brown = new Color(153, 92, 28);
    private Color sun = new Color(255, 241, 0);
    private Color moon = new Color(246, 255, 241);
    private Color snowyGround = new Color(255, 255, 255);
    private Color cloud = new Color(192, 192, 192, (int)(255*0.75));

    private enum Season {SPRING, SUMMER, AUTUMN, WINTER}
    private Season season = Season.SPRING;                  // Holds current season
    private double currentTime = 0;                         // 1-100 (25 per season)
    private final double simTimeScalar = 1.0;               // Time scalar, greater = faster
    private final boolean debug = false;                    // Print debug messages

    private Mountain[] mountains = {new Mountain(), new Mountain(), new Mountain(), new Mountain(), new Mountain(), new Mountain(), new Mountain(), new Mountain(), new Mountain(), new Mountain()};
    private Dimension[] mountainPositions = {new Dimension(), new Dimension(), new Dimension(), new Dimension(), new Dimension(), new Dimension(), new Dimension(), new Dimension(), new Dimension(), new Dimension()};
    private Tree[] trees = {new Tree(), new Tree(), new Tree(), new Tree(), new Tree(), new Tree(), new Tree(), new Tree(), new Tree(), new Tree()};
    private Dimension[] treePositions = {new Dimension(), new Dimension(), new Dimension(), new Dimension(), new Dimension(), new Dimension(), new Dimension(), new Dimension(), new Dimension(), new Dimension()};

    private Rain rain = new Rain();
    private Snow snow = new Snow();
    private int cloudPosition = 0;

    private void drawCloud(int x, int y, Graphics g) {
        g.setColor(cloud);
        g.fillOval(x, y + 25, 150, 50);
        g.fillOval(x + 30, y, 150, 50);
        g.fillOval(x + 40, y + 30, 150, 50);
    }

    public Scenery() {
        setLayout(null);

        // Set randomised locations for mountains and trees
        final int mtn_min_x = 25;   final int mtn_min_y = 200;
        final int mtn_max_x = 500;  final int mtn_max_y = 400;

        for(int i = 0; i < mountainPositions.length; i++) {
            mountainPositions[i].setSize((int)(Math.random() * (mtn_max_x - mtn_min_x + 1) + mtn_min_x), (int)(Math.random() * (mtn_max_y - mtn_min_y + 1) + mtn_min_y));
        }

        final int trees_min_x = 575;  final int trees_min_y = 300;
        final int trees_max_x = 700;  final int trees_max_y = 500;

        for(int i = 0; i < treePositions.length; i++) {
            treePositions[i].setSize((int)(Math.random() * (trees_max_x - trees_min_x + 1) + trees_min_x), (int)(Math.random() * (trees_max_y - trees_min_y + 1) + trees_min_y));
        }

        // Create and start animation thread
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    repaint();

                    // Increment time
                    currentTime += 0.30;

                    cloudPosition += 1;
                    if(cloudPosition >= 800) {
                        cloudPosition = 0;
                    }

                    // Sleep for 50ms
                    try {
                        Thread.sleep((int)(50 / simTimeScalar));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();
    }

    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    public void paintComponent(Graphics g) {
        // Sky
        g.setColor(lightBlue);
        g.fillRect(0, 0, getPreferredSize().width, getPreferredSize().height);

        // FG
        g.setColor(season == Season.WINTER ? snowyGround : brown);
        g.fillRect(0, getPreferredSize().height / 2, getPreferredSize().width, getPreferredSize().height / 2);

        if(debug) {
            g.setColor(Color.BLACK);
            g.drawString(Double.toString(currentTime), 75, 575);
        }

        for(int i = 0; i < mountains.length; i++) {
            if(season == Season.WINTER)
                mountains[i].drawMountain(g, mountainPositions[i], true);
            else
                mountains[i].drawMountain(g, mountainPositions[i], false);
        }

        for(int i = 0; i < trees.length; i++) {
            trees[i].drawTree(g, treePositions[i], season == Season.WINTER, season == Season.AUTUMN);
        }

        switch(season) {
            case SPRING:
                g.setColor(Color.BLACK);
                g.drawString("Spring", 10, 575);
                g.setColor(Color.yellow);
                g.fillOval(25, 25, 100, 100);
                drawCloud(cloudPosition, 50, g);
                drawCloud(cloudPosition + 300, 75, g);
                drawCloud(cloudPosition + 500, 60, g);
                if(currentTime >= 25) {
                    season = Season.SUMMER;
                    rain.clearDrops();
                    cloudPosition = 0;
                    break;
                }

                rain.drawRain(g, currentTime);
                break;
            case SUMMER:
                g.setColor(Color.BLACK);
                g.drawString("Summer", 10, 575);
                g.setColor(Color.yellow);
                g.fillOval(25, 25, 100, 100);
                if(currentTime >= 50) {
                    season = Season.AUTUMN;
                    break;
                }
                break;
            case AUTUMN:
                g.setColor(Color.BLACK);
                g.drawString("Autumn", 10, 575);
                drawCloud(cloudPosition, 50, g);
                drawCloud(cloudPosition + 300, 75, g);
                drawCloud(cloudPosition + 500, 60, g);
                if(currentTime >= 75) {
                    season = Season.WINTER;
                    cloudPosition = 0;
                    break;
                }
                break;
            case WINTER:
                g.setColor(Color.BLACK);
                g.drawString("Winter", 10, 575);
                if(currentTime >= 100) {
                    season = Season.SPRING;

                    // Reset time back to zero
                    currentTime = 0;
                    break;
                }

                snow.drawSnow(g, currentTime);
                break;
        }
    }
}
