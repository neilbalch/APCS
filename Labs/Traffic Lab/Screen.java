import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Screen extends JPanel{
	private ArrayList<Automobile> vehicles;
	private int simTimeScalar = 1;

	public Screen(){
		vehicles = new ArrayList<Automobile>();

		// Add Sedans
        vehicles.add(new Sedan(Color.RED, new Point(800, 110)));

		// Add Sports Cars
		vehicles.add(new SportsCar(Color.BLUE, new Point(800, 340)));

		// Add SUVs
		vehicles.add(new BigCar(Color.BLUE, new Point(850, 330)));

		// Add Trucks
//		vehicles.add(new Automobile(Color.BLUE, new Point(50, 50)));

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

	public Dimension getPreferredSize(){
		return new Dimension(800,600);
	}

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

		// Move and draw Vehicles
		for(int i = 0; i < vehicles.size(); i++) {
			vehicles.get(i).moveBy();
			if(vehicles.get(i).getPosition().x < 0) vehicles.get(i).moveBy(new Dimension(800, 0));
			vehicles.get(i).drawMe(g);
		}
	}
}
