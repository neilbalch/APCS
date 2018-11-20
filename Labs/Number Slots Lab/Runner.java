import javax.swing.JFrame;

public class Runner {
    public static void main(String[] args) {
        Screen sc = new Screen();
        JFrame fr = new JFrame("Slot Machine!");

        fr.add(sc);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();
        fr.setVisible(true);
    }
}