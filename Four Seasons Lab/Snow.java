import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;

class Snowflake {
    private Color snow = new Color(211, 204, 203, 200);
    private final int x_position;
    private int last_y_position;

    public Snowflake(int initial_x) {
        this.x_position = initial_x;
        this.last_y_position = 0;
    }

    public void animateFlake(Graphics g) {
        g.setColor(snow);

        g.fillOval(x_position, last_y_position, 30, 30);

        last_y_position += 10;
    }
}

public class Snow {
    private ArrayList snowflakes = new ArrayList();

    public void clearFlakes() {
        snowflakes.clear();
    }

    public void drawSnow(Graphics g, double currentTime) {
        if(Math.random() > 0.30) { // Give random chance for droplet creation
            snowflakes.add(new Snowflake((int)(Math.random() * 800)));
        }

        for(int i = 0; i < snowflakes.size(); i++) {
            ((Snowflake)snowflakes.get(i)).animateFlake(g);
        }
    }
}
