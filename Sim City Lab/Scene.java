import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

public class Scene extends JPanel {
    private Color lightBlue = new Color(108, 206, 209);
    private Color black = new Color(24, 42, 132);
    private Color brown = new Color(153, 92, 28);
    private Color sun = new Color(255, 241, 0);
    private Color moon = new Color(246, 255, 241);

    private enum Time {DAY, NIGHT, DAWN, DUSK}
    private Time time = Time.DAWN;
    private int skyOpacity = 255;
    private double skyTime = 0;
    private double sunTime = 0;
    private double moonTime = 0;
    private boolean firstRun = true;

    private double simTimeScalar = 1.0;

    public Scene() {
        setLayout(null);

        // Thread for calling repaint
        Runnable fun = new Runnable() {
            @Override
            public void run() {
                while(true){
                    repaint();

                    // Sleep for 50ms
                    try {
                        Thread.sleep((int)(50 / simTimeScalar));
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

        // BG
        Color mutableBlack;
        Color mutableLightBlue;
        switch(time) {
            case DAY:
                firstRun = false;
                skyOpacity = 255;
                if(skyTime > 10) {
                    time = Time.DUSK;
                    break;
                }
                g.setColor(lightBlue);
                g.fillRect(0, 0, getPreferredSize().width, getPreferredSize().height);
                skyTime+= 0.03;
                break;
            case NIGHT:
                skyOpacity = 255;
                if(skyTime > 10) {
                    time = Time.DAWN;
                    break;
                }
                g.setColor(black);
                g.fillRect(0, 0, getPreferredSize().width, getPreferredSize().height);
                skyTime+= 0.03;
                break;
            case DAWN:
                skyTime = 0;
                if(skyOpacity <= 0) {
                    time = Time.DAY;
                    break;
                }
                mutableBlack = new Color(black.getRed(), black.getGreen(), black.getBlue(), skyOpacity);
                g.setColor(mutableBlack);
                g.fillRect(0, 0, getPreferredSize().width, getPreferredSize().height);
                mutableLightBlue = new Color(lightBlue.getRed(), lightBlue.getGreen(), lightBlue.getBlue(), 255 - skyOpacity);
                g.setColor(mutableLightBlue);
                g.fillRect(0, 0, getPreferredSize().width, getPreferredSize().height);
                skyOpacity--;
                break;
            case DUSK:
                skyTime = 0;
                if(skyOpacity <= 0) {
                    time = Time.NIGHT;
                    break;
                }
                mutableLightBlue = new Color(lightBlue.getRed(), lightBlue.getGreen(), lightBlue.getBlue(), skyOpacity);
                g.setColor(mutableLightBlue);
                g.fillRect(0, 0, getPreferredSize().width, getPreferredSize().height);
                mutableBlack = new Color(black.getRed(), black.getGreen(), black.getBlue(), 255 - skyOpacity);
                g.setColor(mutableBlack);
                g.fillRect(0, 0, getPreferredSize().width, getPreferredSize().height);
                skyOpacity--;
                break;
        }

        // Sun Setup
        if(time == Time.DAY || time == Time.DAWN || time == Time.DUSK) {
            double period = 8.5;
            int x = 350 + (int)(325 * Math.cos(-sunTime / period));
            int y = 300 + (int)(275 * Math.sin(-sunTime / period));

            g.setColor(sun);
            g.fillOval(x, y, 75, 75);

            sunTime += 0.03;
        } else
            sunTime = 0;

        // Moon Setup
        if((time == Time.NIGHT || time == Time.DAWN || time == Time.DUSK) && !firstRun) {
            int x = 350 + (int)(325 * Math.cos(-moonTime / 8.5));
            int y = 300 + (int)(275 * Math.sin(-moonTime / 8.5));

            g.setColor(moon);
            g.fillOval(x, y, 75, 75);

            moonTime += 0.03;
        } else
            moonTime = 0;


        // FG
        g.setColor(brown);
        g.fillRect(0, getPreferredSize().height / 2, getPreferredSize().width, getPreferredSize().height / 2);

        // Commercial Areas
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++)
                Commercial.drawCommercialBuilding(g, new Dimension(50 + j * 100 + i * 25, 150 + i * 50));
        }

        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++)
                Commercial.drawCommercialBuilding(g, new Dimension(575 + j * 100 + i * 25, 300 + i * 50));
        }

        // Residential Areas
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++)
                House.drawHouse(g, new Dimension(50 + j * 100 - i * 15, 450 + i * 50));
        }

        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++)
                House.drawHouse(g, new Dimension(300 + j * 100 + i * 15, 300 + i * 50));
        }

        // Parks
        Foliage.drawPark(g, new Dimension(300, 450));
        Foliage.drawPark(g, new Dimension(450, 500));
    }
}
