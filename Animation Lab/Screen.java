import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

public class Screen extends JPanel {
    private Color sky = new Color(88, 142, 146);
    private Color land = new Color(157, 102, 12);
    private Color grass = new Color(19, 131, 2);
    private Color sun = new Color(255, 241, 0);
    private Color tumbleweed = new Color(196, 144, 77, 200);
    private Color tumbleweedWeeds = new Color(134, 99, 53);
    private Color trees = new Color(134, 69, 40);
    private Color cloud = new Color(192, 192, 192, (int)(255*0.75));

    private int grassPosition = 0;

    private Dimension sunPosition = new Dimension(getPreferredSize().width / 2, 25);

    private int tumbleweedPosition = -300;

    private int treeLeafHeight = 0;

    private int cloudPosition = 0;

    public Screen() {
        setFocusable(true);

        // Thread for animation loop
        Runnable fun = new Runnable() {
            @Override
            public void run() {
                int time = 0;
                double sunTime = 0.90;

                while(true){
                    grassPosition = (int)(15 * Math.sin(time / 8.0));

                    sunPosition.setSize(350 + (int)(350 * Math.sin(sunTime)), 450 + (int)(250 * (Math.cos(sunTime) - 1)));

                    tumbleweedPosition += 5;
                    if(tumbleweedPosition >= 900) {
                        tumbleweedPosition = -300;
                    }

                    // Decrement sunTime
                    if(sunTime >= Math.PI + 1.75) {
                        sunTime = 0.90;
                    } else {
                        sunTime += 0.01;
                    }

                    // Implement tree leaf motion
                    treeLeafHeight = (int)(10 * Math.sin(time / 10.0));

                    cloudPosition += 1;
                    if(cloudPosition >= 800) {
                        cloudPosition = 0;
                    }

                    time++;
                    repaint();

                    // Sleep for 50ms
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        // Create and start animation thread
        Thread t = new Thread(fun);
        t.start();
    }

    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Paint BG
        g.setColor(sky);
        g.fillRect(0,0, getPreferredSize().width, getPreferredSize().height);

        // Draw Sun
        g.setColor(sun);
        g.fillOval(sunPosition.width, sunPosition.height, 100, 100);
        g.setColor(Color.WHITE);
        g.fillOval(sunPosition.width + 13, sunPosition.height + 13, 75, 75);

        // Draw Cloud
        g.setColor(cloud);
        g.fillOval(cloudPosition, 50 + 25, 150, 50);
        g.fillOval(cloudPosition + 30, 50, 150, 50);
        g.fillOval(cloudPosition + 40, 50 + 30, 150, 50);

        // Paint land
        g.setColor(land);
        g.fillRect(0, (int)(getPreferredSize().height / 3), getPreferredSize().width, (int)(getPreferredSize().height * (2.0/3.0)));

        // Draw Forest
        Dimension root = new Dimension(300, 100);
        int v1 = 0;
        int v2 = 0;
        while(v2 < 4) {
            root.setSize(300, root.height + 80);
            while(v1 < 3) {
                root.setSize(root.width + 100, root.height);

                g.setColor(trees);
                g.fillRect(root.width + 40, root.height + 20, 30, 100);
                g.setColor(Color.GREEN);
                g.fillOval(root.width, root.height + treeLeafHeight, 50, 50);
                g.fillOval(root.width + 45, root.height - treeLeafHeight, 50, 50);

                v1++;
            }
            v1 = 0;
            v2++;
        }

        // Draw tumbleweed
        g.setColor(tumbleweed);
        g.fillOval(tumbleweedPosition, 250, 150, 150);
        g.setColor(tumbleweedWeeds);
        g.drawArc(tumbleweedPosition + 15, 250 + 10, 100, 100, 45, 180);
        g.drawArc(tumbleweedPosition + 50, 250 + 40, 100, 100, 160, 330);
        g.drawArc(tumbleweedPosition + 40, 250 + 40, 100, 100, 11, 234);
        g.drawArc(tumbleweedPosition + 70, 250 + 20, 100, 100, 423, 345);
        g.drawArc(tumbleweedPosition + 30, 250 + 60, 100, 100, 34, 324);
        g.drawArc(tumbleweedPosition + 20, 250 + 80, 100, 100, 14, 343);

        // Draw Grass
        g.setColor(grass);
        Dimension corner = new Dimension(0, getPreferredSize().height);
        int i = 0;
        while(i < 27) {
            int[] x_pts = {corner.width, corner.width + 15 + grassPosition, corner.width + 30};
            int[] y_pts = {corner.height, corner.height - 100, corner.height};

            g.fillPolygon(x_pts, y_pts, x_pts.length);

            // move the corner over
            corner.setSize(corner.width + 30, corner.height);
            i++;
        }

    }
}