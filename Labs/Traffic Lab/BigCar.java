import java.awt.*;

// NOT for drawing
public class BigCar extends Automobile {
   public BigCar(Color bodyColor, Point position) {
      super(bodyColor, position);
      setDimensions(new Dimension(40, 20));
   }

   @Override
   public void drawMe(Graphics g) {
      // Frame
      g.setColor(getBodyColor());
      g.fillRect(getPosition().x, getPosition().y, getSize().width, getSize().height);

      // Wheels
      g.setColor(Color.black);
      int wheel_diameter = 16;
      g.fillOval(getPosition().x + 1, getPosition().y + 15, wheel_diameter, wheel_diameter);
      g.fillOval(getPosition().x + 20, getPosition().y + 15, wheel_diameter, wheel_diameter);

      // Hubs
      g.setColor(Color.LIGHT_GRAY);
      int hub_diameter = 10;
      g.fillOval(getPosition().x + 5,getPosition().y + 18, hub_diameter, hub_diameter);
      g.fillOval(getPosition().x + 24,getPosition().y + 18, hub_diameter, hub_diameter);

      // Cabin
      g.setColor(new Color(162, 171, 168, 200));
      int[] x_val = {getPosition().x + 3, getPosition().x + 18,   getPosition().x + 30,   getPosition().x + 37};
      int[] y_val = {getPosition().y,     getPosition().y - 10,    getPosition().y - 10,    getPosition().y};
      g.fillPolygon(x_val, y_val, x_val.length);

      // Lights
      g.setColor(Color.YELLOW);
      g.fillOval(getPosition().x - 3, getPosition().y - 1, 7, 7);
   }
}