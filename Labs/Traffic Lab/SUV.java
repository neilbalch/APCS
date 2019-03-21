import java.awt.*;

public class SUV extends BigCar {
    public SUV(Color bodyColor, Point position) {
        super(bodyColor, position);
        super.setSpeed(4);
    }

    @Override
    public void drawMe(Graphics g) {
        super.drawMe(g);

        // Add door lines
        g.setColor(Color.BLACK);
        g.drawLine(getPosition().x + 10,    getPosition().y,                        getPosition().x + 16, getPosition().y + getSize().height);
        g.drawLine(getPosition().x + 20,    getPosition().y + getSize().height, getPosition().x + 28,  getPosition().y);
    }
}
