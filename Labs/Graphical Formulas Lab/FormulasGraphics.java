import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.imageio.ImageIO;


public class FormulasGraphics extends JPanel implements ActionListener {
    private BufferedImage bg;

    // Pythagorean Therom Setup
    private JButton pythagoreanButton;
    private JTextField sideAInput;
    private JTextField sideBInput;
    private double hypLength = 0.0;
    private Dimension pythagoreanLocation = new Dimension(25, 25);

    // Quadratic Formula Setup
    private JButton quadraticButton;
    private JTextField aInput;
    private JTextField bInput;
    private JTextField cInput;
    String x_1 = "0.0";
    String x_2 = "0.0";
    private Dimension quadraticLocation = new Dimension(pythagoreanLocation.width + 300, pythagoreanLocation.height);

    // Distance Formula Setup
    private JButton distanceButton;
    private JTextField x1Input;
    private JTextField x2nput;
    private JTextField y1nput;
    private JTextField y2nput;
    double distance = 0.0;
    private Dimension distanceLocation = new Dimension(pythagoreanLocation.width, pythagoreanLocation.height + 250);

    // Sphere Volume Setup
    private JButton volumeButton;
    private JTextField radius;
    double volume = 0.0;
    private Dimension volumeLocation = new Dimension(distanceLocation.width + 300, distanceLocation.height);

    public FormulasGraphics() {
        setLayout(null); // Disable layouts

        // Import BG image.
        try {
            bg = ImageIO.read(new File("./bg.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Pythagorean Therom Setup
        pythagoreanButton = new JButton("Pythagorean Therom");
        pythagoreanButton.setBounds(pythagoreanLocation.width, pythagoreanLocation.height + 100, 160, 30);
        add(pythagoreanButton);
        pythagoreanButton.addActionListener(this); // this.actionPerformed is called when button is pressed

        sideAInput = new JTextField();
        sideAInput.setBounds(pythagoreanLocation.width, pythagoreanLocation.height + 20, 150, 30);
        add(sideAInput);

        sideBInput = new JTextField();
        sideBInput.setBounds(pythagoreanLocation.width, pythagoreanLocation.height + 65, 150, 30);
        add(sideBInput);

        // Quadratic Setup
        quadraticButton = new JButton("Quadratic Formula");
        quadraticButton.setBounds(quadraticLocation.width, quadraticLocation.height + 160, 160, 30);
        add(quadraticButton);
        quadraticButton.addActionListener(this); // this.actionPerformed is called when button is pressed

        aInput = new JTextField();
        aInput.setBounds(quadraticLocation.width, quadraticLocation.height + 20, 150, 30);
        add(aInput);

        bInput = new JTextField();
        bInput.setBounds(quadraticLocation.width, quadraticLocation.height + 65, 150, 30);
        add(bInput);

        cInput = new JTextField();
        cInput.setBounds(quadraticLocation.width, quadraticLocation.height + 110, 150, 30);
        add(cInput);

        // Distance Formula Setup
        distanceButton = new JButton("Distance Formula");
        distanceButton.setBounds(distanceLocation.width, distanceLocation.height + 205, 160, 30);
        add(distanceButton);
        distanceButton.addActionListener(this); // this.actionPerformed is called when button is pressed

        x1Input = new JTextField();
        x1Input.setBounds(distanceLocation.width, distanceLocation.height + 20, 150, 30);
        add(x1Input);

        y1nput = new JTextField();
        y1nput.setBounds(distanceLocation.width, distanceLocation.height + 65, 150, 30);
        add(y1nput);

        x2nput = new JTextField();
        x2nput.setBounds(distanceLocation.width, distanceLocation.height + 110, 150, 30);
        add(x2nput);
        y2nput = new JTextField();
        y2nput.setBounds(distanceLocation.width, distanceLocation.height + 155, 150, 30);
        add(y2nput);

        // Sphere Volume Setup
        volumeButton = new JButton("Sphere Volume");
        volumeButton.setBounds(volumeLocation.width, volumeLocation.height + 65, 160, 30);
        add(volumeButton);
        volumeButton.addActionListener(this); // this.actionPerformed is called when button is pressed

        radius = new JTextField();
        radius.setBounds(volumeLocation.width, volumeLocation.height + 20, 150, 30);
        add(radius);

        setFocusable(true);
    }

    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        double scaleFactor = 0.60;
        g.drawImage(bg, 0,0, (int)(bg.getWidth() * scaleFactor), (int)(bg.getHeight() * scaleFactor), null);

        // Draw text elements
        g.drawString("Pythagorean Therom:", pythagoreanLocation.width, pythagoreanLocation.height);
        g.drawString("Enter a side length:", pythagoreanLocation.width, pythagoreanLocation.height + 15);
        g.drawString("Enter a side length:", pythagoreanLocation.width, pythagoreanLocation.height + 60);
        g.drawString("The hypotenuse length is: " + hypLength, pythagoreanLocation.width, pythagoreanLocation.height + 140);

        g.drawString("Quadratic Formula:", quadraticLocation.width, quadraticLocation.height);
        g.drawString("a:", quadraticLocation.width, quadraticLocation.height + 15);
        g.drawString("b:", quadraticLocation.width, quadraticLocation.height + 60);
        g.drawString("c:", quadraticLocation.width, quadraticLocation.height + 105);
        g.drawString("The solutions are: " + x_1 + (x_2 == "" ? "" : " and " + x_2), quadraticLocation.width, quadraticLocation.height + 155);

        g.drawString("Distance Formula:", distanceLocation.width, distanceLocation.height);
        g.drawString("x1:", distanceLocation.width, distanceLocation.height + 15);
        g.drawString("y1:", distanceLocation.width, distanceLocation.height + 60);
        g.drawString("x2:", distanceLocation.width, distanceLocation.height + 105);
        g.drawString("y2:", distanceLocation.width, distanceLocation.height + 150);
        g.drawString("The distance is: " + distance, distanceLocation.width, distanceLocation.height + 200);

        g.drawString("Sphere Volume:", volumeLocation.width, volumeLocation.height);
        g.drawString("radius:", volumeLocation.width, volumeLocation.height + 15);
        g.drawString("The volume is: " + volume, volumeLocation.width, volumeLocation.height + 60);
    }

    // Called when something happens in the JPanel
    public void actionPerformed(ActionEvent e) {
        // Which Button was pressed
        if(e.getSource() == pythagoreanButton) { // Pythagorean Therom
            double side_a = Double.parseDouble(sideAInput.getText());
            double side_b = Double.parseDouble(sideBInput.getText());
            hypLength = Math.sqrt(Math.pow(side_a, 2) + Math.pow(side_b, 2));
        } else if (e.getSource() == quadraticButton) { // Quadratic Formula
            double a = Double.parseDouble(aInput.getText());
            double b = Double.parseDouble(bInput.getText());
            double c = Double.parseDouble(cInput.getText());
            if((Math.pow(b,2) - 4 * a * c) < 0) {
                x_1 = "Err: Unreal Answers";
                x_2 = "";
            } else {
                x_1 = Double.toString((-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a));
                x_2 = Double.toString((-b - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a));
            }
        } else if(e.getSource() == distanceButton) { // Distance Formula
            double x1 = Double.parseDouble(x1Input.getText());
            double x2 = Double.parseDouble(x2nput.getText());
            double y1 = Double.parseDouble(y1nput.getText());
            double y2 = Double.parseDouble(y2nput.getText());
            distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        } else if(e.getSource() == volumeButton) { // Sphere Volume
            double radius_qty = Double.parseDouble(radius.getText());
            volume = (4.0 / 3.0) * Math.PI * Math.pow(radius_qty, 3);
        }

        repaint(); // Redraw the JPanel
    }
}