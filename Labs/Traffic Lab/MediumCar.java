import java.awt.*;

// NOT for drawing
public class MediumCar extends Automobile {
   public MediumCar(Color bodyColor, Point position) {
      super(bodyColor, position);
      setDimensions(new Dimension(35, 15));
   }

   @Override
   public void drawMe(Graphics g) {
      // Frame
      g.setColor(getBodyColor());
      g.fillRect(getPosition().x, getPosition().y, getSize().width, getSize().height);

      // Wheels
      g.setColor(Color.black);
      int wheel_diameter = 12;
      g.fillOval(getPosition().x + 1, getPosition().y + 7, wheel_diameter, wheel_diameter);
      g.fillOval(getPosition().x + 20, getPosition().y + 7, wheel_diameter, wheel_diameter);

      // Hubs
      g.setColor(Color.LIGHT_GRAY);
      int hub_diameter = 6;
      g.fillOval(getPosition().x + 4,getPosition().y + 10, hub_diameter, hub_diameter);
      g.fillOval(getPosition().x + 23,getPosition().y + 10, hub_diameter, hub_diameter);

      // Cabin
      g.setColor(new Color(162, 171, 168, 200));
      int[] x_val = {getPosition().x + 3, getPosition().x + 15,   getPosition().x + 25,   getPosition().x + 33};
      int[] y_val = {getPosition().y,     getPosition().y - 7,    getPosition().y - 7,    getPosition().y};
      g.fillPolygon(x_val, y_val, x_val.length);

      // Lights
      g.setColor(Color.YELLOW);
      g.fillOval(getPosition().x - 3, getPosition().y - 1, 7, 7);
   }
}