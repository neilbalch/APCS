import java.awt.*;

public class SportsCar extends MediumCar {
    public SportsCar(Color bodyColor, Point position) {
        super(bodyColor, position);
        setSpeed(5);
    }

    @Override
    public void drawMe(Graphics g) {
        super.drawMe(g);

        // Draw front door
        g.setColor(getBodyColor());
        int[] x_val = {getPosition().x, getPosition().x,                    getPosition().x - 15};
        int[] y_val = {getPosition().y, getPosition().y + getSize().height, getPosition().y + getSize().height};
        g.fillPolygon(x_val, y_val, x_val.length);

        // Add door line
        g.setColor(Color.BLACK);
        g.drawLine(getPosition().x + 15, getPosition().y, getPosition().x + 15, getPosition().y + getSize().height);
    }
}