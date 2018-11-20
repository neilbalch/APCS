import javax.swing.JFrame;

public class Runner {
    public static void main(String[] args) {
        FormulasGraphics fg = new FormulasGraphics();

        JFrame fr = new JFrame("Formulas");
        fr.add(fg);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();
        fr.setVisible(true);

    }
}