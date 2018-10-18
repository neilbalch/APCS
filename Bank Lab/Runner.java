import javax.swing.*;

public class Runner {
    public static void main(String[] args) {
        JFrame fr = new JFrame("Bank");
        Screen sc = new Screen();

        fr.add(sc);
        fr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fr.pack();
        fr.setVisible(true);
    }
}

