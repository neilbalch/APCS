import java.awt.*;

public class SportsCar extends MediumCar {
    public SportsCar(Color bodyColor, Point position) { super(bodyColor, position); }

    @Override
    public void drawMe(Graphics g) {
        super.drawMe(g);

        // Draw front door
        g.setColor(getBodyColor());
        int[] x_val = {getPosition().x, getPosition().x,                    getPosition().x - 15};
        int[] y_val = {getPosition().y, getPosition().y + getSize().height, getPosition().y + getSize().height};
        g.fillPolygon(x_val, y_val, x_val.length);
    }
}