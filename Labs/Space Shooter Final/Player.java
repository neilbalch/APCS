import java.awt.Graphics;
import java.awt.Dimension;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Player {
    private Dimension location;
    private Dimension size;
    private BufferedImage image;

    public Player(int x, int y) {
        this.location = new Dimension(x, y);
        this.size = new Dimension(50, 50);

        try {
            image = ImageIO.read(new File("ship.png"));
        } catch (IOException ex) {
            // handle exception...
        }
    }


    public void drawMe(Graphics g, ImageObserver i){
        g.drawImage(image, location.width, location.height, size.width, size.height, i);
    }

    public void move(int d_x, int d_y) {
        this.location.width += d_x;
        this.location.height += d_y;
    }

    public int getX(){
        return location.width;
    }

    public int getY(){
        return location.height;
    }

    public int getWidth() {
        return size.width;
    }

    public int getHeight() {
        return size.height;
    }
}
