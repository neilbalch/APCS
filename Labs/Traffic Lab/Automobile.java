import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;
import java.awt.Dimension;

// NOT for drawing
public class Automobile {
	private Color bodyColor;
	private Point position;
	private Dimension size;
	private int speed;

	public Automobile(Color bodyColor, Point position) {
		this.bodyColor = bodyColor;
		this.size = new Dimension(70, 20);
		this.position = position;
		this.speed = 2;
	}

	public void drawMe(Graphics g) {
	    // Body
		g.setColor(bodyColor);
		g.fillRect(position.x, position.y, size.width, size.height);

		// Wheels
		g.setColor(Color.black);
		g.fillOval(position.x + 5,position.y + 10, 15, 15);
		g.fillOval(position.x + 50,position.y + 10, 15, 15);
	}


	public void moveBy() { moveBy(new Dimension(speed, 0)); }
	public void moveBy(Dimension displacement) {
		position.x += displacement.width;
		position.y += displacement.height;
	}

	public int getSpeed() { return speed; }
	public void setSpeed(int speed) { this.speed = speed; }
	public Color getBodyColor() { return  bodyColor; }
	public Point getPosition() { return position; }
	public void setPosition(Point position) { this.position = position; }
	public Dimension getSize() { return size; }
	public void setDimensions(Dimension size) { this.size = size; }
}