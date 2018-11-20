import javax.swing.JFrame;

public class Runner {
    public static void main(String[] args) {
        Scenery sc = new Scenery();
        JFrame fr = new JFrame("All des seasons");

        fr.add(sc);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();
        fr.setVisible(true);
    }
}
