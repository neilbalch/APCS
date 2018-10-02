import javax.swing.JPanel;
import java.awt.*;

public class Circles extends JPanel {
    private int x, y;

    public Circles() {
        //(1) What is imported to get Graphics to work?
        // JPanel, color, graphics and dimension
        x = 400;
        y = 200;
    }

    public Dimension getPreferredSize() {
        //Sets the size of the panel
        return new Dimension(1280,720);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Dimension root = this.getPreferredSize();
        root.setSize((root.width / 4), (root.height / 4));

        //(2) In the paintComponent method, what do you think it is drawing?
        // the red filled rectangle
        Color colorBrown = new Color(110, 1, 17);
        Color colorGreen = new Color(0, 171, 25);
        Color colorYellow = new Color(242, 255, 0);

        g.setColor(colorBrown);
        g.fillRect(root.width + (75 / 2 - 25 / 2), root.height + 10,25,150);

        g.setColor(colorGreen);
        g.fillOval(root.width, root.height, 75, 50);

        g.setColor(colorYellow);
        g.fillOval(root.width + 300, root.height, 100, 100);
    }
}