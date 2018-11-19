import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;

class Raindrop {
    private Color rain = new Color(25, 172, 158, 200);
    private final int x_position;
    private int last_y_position;

    public Raindrop(int initial_x) {
        this.x_position = initial_x;
        this.last_y_position = 0;
    }

    public void animateDrop(Graphics g) {
        g.setColor(rain);

        int[] x_pts = {x_position, x_position + 15, x_position + 30};
        int[] y_pts = {last_y_position, last_y_position - 30, last_y_position};
        g.fillPolygon(x_pts, y_pts, x_pts.length);
        g.fillOval(x_position, last_y_position - 5, 30, 30);

        last_y_position += 10;
    }
}

public class Rain {
    private ArrayList raindrops = new ArrayList();

    public void clearDrops() {
        raindrops.clear();
    }

    public void drawRain(Graphics g, double currentTime) {
        if(Math.random() > 0.30) { // Give random chance for droplet creation
            raindrops.add(new Raindrop((int)(Math.random() * 800)));
        }

        for(int i = 0; i < raindrops.size(); i++) {
            ((Raindrop)raindrops.get(i)).animateDrop(g);
        }
    }
}
