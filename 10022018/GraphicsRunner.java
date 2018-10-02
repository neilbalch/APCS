import javax.swing.JFrame;

public class GraphicsRunner {
    public static void main( String args[] ) {
        //(1) What does the constructor of JFrame takes in? What does it do?
        // the desired window title
        JFrame frame = new JFrame("Circle5");

        //Create JPanel object and add it to the frame
        Circles canvas = new Circles();
        frame.add(canvas);

        //(2) What do you think this command does?
        // allows the window to be closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //(3) What happens when you remove the code below?
        //Try and Test.
        // no graphics are drawn
        frame.pack();

        //(4) What does setVisible do? What happens when you remove the code below?
        //Try and Test.
        // Makes the JFrame visible
        frame.setVisible(true);
    }
}