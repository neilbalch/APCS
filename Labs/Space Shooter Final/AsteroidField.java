import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.image.ImageObserver;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

class Asteroid {
    private Color rain = new Color(25, 172, 158, 200);
    private BufferedImage image;
    private int last_x_position;
    private final int y_position;

    public Asteroid(int initial_y) {
        this.last_x_position = 800;
        this.y_position = initial_y;

        try {
            image = ImageIO.read(new File("asteroid.png"));
        } catch (IOException ex) {
            // handle exception...
        }
    }

    public void animateAsteroid(Graphics g, ImageObserver i) {
        g.drawImage(image, last_x_position, y_position, 10, 10, i);

        // Move asteroid for next draw call
        last_x_position -= 2;
    }

    public boolean isPastScreenEdge() {
        if(last_x_position <= 0) return true;
        else return false;
    }
}

public class AsteroidField {
    private ArrayList<Asteroid> asteroids = new ArrayList<>();

    public void clearAsteroids() {
        asteroids.clear();
    }

    public void drawAsteroids(Graphics g, ImageObserver img) {
        if(Math.random() < 0.10) { // Give random chance for droplet creation
            asteroids.add(new Asteroid((int)(Math.random() * 800)));
        }

        for(int i = 0; i < asteroids.size(); i++) {
            if(((Asteroid)asteroids.get(i)).isPastScreenEdge()) asteroids.remove(i); // Garbage collection, and to prevent using ALL of the RAM! JAVA is TERRIBLE at resource management, we wouldn't need to do this in C++ or anything else. Maybe in JavaScript.
            else ((Asteroid) asteroids.get(i)).animateAsteroid(g, img);
        }
    }
}
