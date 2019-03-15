import java.awt.*;

public class Sedan extends MediumCar {
    public Sedan(Color bodyColor, Point position) { super(bodyColor, position); }

    @Override
    public void drawMe(Graphics g) {
        super.drawMe(g);

        // Add door lines
        g.setColor(Color.BLACK);
        g.drawLine(getPosition().x + 10, getPosition().y, getPosition().x + 13, getPosition().y + getSize().height);
        g.drawLine(getPosition().x + 20, getPosition().y + getSize().height, getPosition().x + 25, getPosition().y);
    }
}
