import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Screen extends JPanel{
	private ArrayList<Automobile> vehicles;

	public Screen(){
		vehicles = new ArrayList<Automobile>();

		// Add Sedans
//		vehicles.add(new Automobile(Color.BLUE, new Point(50, 50)));
        vehicles.add(new MediumCar(Color.RED, new Point(300, 250)));

		// Add Sports Cars
//		vehicles.add(new Automobile(Color.BLUE, new Point(50, 50)));

		// Add SUVs
//		vehicles.add(new Automobile(Color.BLUE, new Point(50, 50)));

		// Add Trucks
//		vehicles.add(new Automobile(Color.BLUE, new Point(50, 50)));
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

		// Draw Vehicles
		for(int i = 0; i < vehicles.size(); i++) vehicles.get(i).drawMe(g);
	}
}
