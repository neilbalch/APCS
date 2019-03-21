import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Screen extends JPanel{
	private ArrayList<Automobile> vehicles;
	private ArrayList<Automobile> topRoad;
	private ArrayList<Automobile> bottomRoad;
	private ArrayList<Automobile> frontageRoad;
	private int simTimeScalar = 1;

	public Screen(){
		vehicles = new ArrayList<Automobile>();
		topRoad = new ArrayList<Automobile>();
		bottomRoad = new ArrayList<Automobile>();
		frontageRoad = new ArrayList<Automobile>();

		topRoad.add(new Sedan(Color.RED,			new Point(10, 110)));
		topRoad.add(new Sedan(Color.YELLOW,			new Point(75, 110)));
		topRoad.add(new Sedan(Color.PINK,			new Point(130, 110)));
		topRoad.add(new Sedan(Color.GREEN, 			new Point(190, 110)));
		topRoad.add(new SportsCar(Color.BLUE, 		new Point(250, 110)));
		topRoad.add(new SportsCar(Color.MAGENTA,	new Point(300, 110)));
		topRoad.add(new SUV(Color.ORANGE, 			new Point(450, 100)));
		topRoad.add(new SUV(Color.CYAN, 			new Point(570, 110)));
		topRoad.add(new Truck(Color.GREEN, 			new Point(650, 90)));
		topRoad.add(new Truck(Color.PINK, 			new Point(720, 90)));

		bottomRoad.add(new Sedan(Color.YELLOW,		new Point(10, 335)));
		bottomRoad.add(new Truck(Color.GREEN, 		new Point(75, 315)));
		bottomRoad.add(new SportsCar(Color.BLUE, 	new Point(130, 335)));
		bottomRoad.add(new Sedan(Color.GREEN, 		new Point(190, 335)));
		bottomRoad.add(new SUV(Color.CYAN, 			new Point(250, 335)));
		bottomRoad.add(new Sedan(Color.RED,			new Point(300, 335)));
		bottomRoad.add(new SportsCar(Color.MAGENTA,	new Point(450, 335)));
		bottomRoad.add(new SUV(Color.ORANGE, 		new Point(570, 100)));
		bottomRoad.add(new Sedan(Color.PINK,		new Point(650, 335)));
		bottomRoad.add(new Truck(Color.PINK, 		new Point(720, 315)));

		// Animation thread
		Thread worker = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					repaint();

					// Sleep for 50ms
					try {
						Thread.sleep((int)(50 / simTimeScalar));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		worker.start();
	}

	public Dimension getPreferredSize(){ return new Dimension(800,600); }

	public void paintComponent(Graphics g){
		super.paintComponent(g);

		// Draw background
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getPreferredSize().width, getPreferredSize().height);

		// Draw Road 1
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 75, getPreferredSize().width, 74);
		g.setColor(Color.GRAY);
		g.fillRect(0, 75 + 12, getPreferredSize().width, 50);
		g.setColor(Color.WHITE);
		for(int x = 10; x < 800; x += 30) g.fillRect(x, 75 + 12 + 20, 20, 5);

		// Draw Road 2
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 300, getPreferredSize().width, 74);
		g.setColor(Color.GRAY);
		g.fillRect(0, 300 + 12, getPreferredSize().width, 50);
		g.setColor(Color.WHITE);
		for(int x = 10; x < 800; x += 30) g.fillRect(x, 300 + 12 + 20, 20, 5);

		// Draw crossroad
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(200, 149, 74, 151);

		// Check if vehicle wants to switch roads
		for(int i = 0; i < topRoad.size(); i++) {
		    if(topRoad.get(i).getPosition().x <= 225 && topRoad.get(i).getPosition().x >= 210 && (int)(10 * Math.random()) == 0) { // vehicle wants to move
				topRoad.get(i).setDirection(Automobile.MoveDirection.DOWN);
				frontageRoad.add(topRoad.get(i));
				topRoad.remove(i);
			}
		}
		for(int i = 0; i < bottomRoad.size(); i++) {
			if(bottomRoad.get(i).getPosition().x <= 215 && bottomRoad.get(i).getPosition().x >= 210 && (int)(10 * Math.random()) == 0) { // vehicle wants to move
				bottomRoad.get(i).setDirection(Automobile.MoveDirection.UP);
				frontageRoad.add(bottomRoad.get(i));
				bottomRoad.remove(i);
			}
		}

		// Move and draw Vehicles
		for(int i = 0; i < frontageRoad.size(); i++) {
			if(frontageRoad.get(i).getDirection() == Automobile.MoveDirection.UP) {
				frontageRoad.get(i).moveBy(new Dimension(0, -frontageRoad.get(i).getSpeed()));
				if(frontageRoad.get(i).getPosition().y + frontageRoad.get(i).getSize().height < 110) { // Have we reached the other road?
					frontageRoad.get(i).setDirection(Automobile.MoveDirection.NOTONFRONTAGEROAD);
					topRoad.add(frontageRoad.get(i));
					frontageRoad.remove(i);
				} else frontageRoad.get(i).drawMe(g);
			} else if(frontageRoad.get(i).getDirection() == Automobile.MoveDirection.DOWN) {
				frontageRoad.get(i).moveBy(new Dimension(0, frontageRoad.get(i).getSpeed()));
				if(frontageRoad.get(i).getPosition().y > 335) { // Have we reached the other road?
					frontageRoad.get(i).setDirection(Automobile.MoveDirection.NOTONFRONTAGEROAD);
					bottomRoad.add(frontageRoad.get(i));
					frontageRoad.remove(i);
                } else frontageRoad.get(i).drawMe(g);
			}
		}
		for(int i = 0; i < topRoad.size(); i++) {
			topRoad.get(i).moveBy();
			if(topRoad.get(i).getPosition().x + topRoad.get(i).getSize().width < 0) topRoad.get(i).moveBy(new Dimension(800 + topRoad.get(i).getSize().width, 0));
			topRoad.get(i).drawMe(g);
		}
		for(int i = 0; i < bottomRoad.size(); i++) {
			bottomRoad.get(i).moveBy();
			if(bottomRoad.get(i).getPosition().x + bottomRoad.get(i).getSize().width < 0) bottomRoad.get(i).moveBy(new Dimension(800 + bottomRoad.get(i).getSize().width, 0));
			bottomRoad.get(i).drawMe(g);
		}
	}
}
