import java.awt.*;

public class Truck extends BigCar {
    public Truck(Color bodyColor, Point position) {
        super(bodyColor, position);
        setDimensions(new Dimension(50, 18));
        super.setSpeed(2);
    }

    @Override
    public void drawMe(Graphics g) {
        // Frame
        g.setColor(getBodyColor());
        g.fillRect(getPosition().x, getPosition().y, (int)(getSize().width / 2.0), getSize().height);

        // Add Bed
        g.setColor(Color.darkGray);
        g.fillRect((int)(getPosition().x + getSize().width / 2.0), (int)(getPosition().y + getSize().height * 2.0/3.0), (int)(getSize().width / 2.0), getSize().height / 3);

        // Cabin
        g.setColor(new Color(162, 171, 168, 200));
        int[] x_val = {getPosition().x, getPosition().x + 10,   getPosition().x + getSize().width / 2,   getPosition().x + getSize().width / 2};
        int[] y_val = {getPosition().y, getPosition().y - 10,   getPosition().y - 10,   getPosition().y};
        g.fillPolygon(x_val, y_val, x_val.length);

        // Wheels
        g.setColor(Color.black);
        int wheel_diameter = 16;
        g.fillOval(getPosition().x + 1,  getPosition().y + 15,   wheel_diameter,   wheel_diameter);
        g.fillOval(getPosition().x + 25, getPosition().y + 15,   wheel_diameter,   wheel_diameter);

        // Hubs
        g.setColor(Color.LIGHT_GRAY);
        int hub_diameter = 10;
        g.fillOval(getPosition().x + 5,  getPosition().y + 18,   hub_diameter,  hub_diameter);
        g.fillOval(getPosition().x + 29, getPosition().y + 18,   hub_diameter,  hub_diameter);

        // Lights
        g.setColor(Color.YELLOW);
        g.fillOval(getPosition().x - 3, getPosition().y + 3, 7, 7);

        // Add door line
        g.setColor(Color.BLACK);
        g.drawLine(getPosition().x + 15, getPosition().y, getPosition().x + 15, getPosition().y + getSize().height);
    }
}
