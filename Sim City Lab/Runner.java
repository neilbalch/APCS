import javax.swing.JFrame;

public class Runner {
    public static void main(String[] args) {
        Scene sc = new Scene();
        JFrame fr = new JFrame("City");

        fr.add(sc);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();
        fr.setVisible(true);
    }
}
