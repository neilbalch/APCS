import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JButton;

public class Screen extends JPanel implements ActionListener {
    private SlotMachine sm = new SlotMachine(100);

    private JButton one;
    private JButton five;
    private JButton ten;
    private JButton spin;

    public Screen() {
        setLayout(null);

        Dimension root = new Dimension(350, 400);

        one = new JButton("Bet 1pt");
        five = new JButton("Bet 5pts");
        ten = new JButton("Bet 10pts");
        spin = new JButton("Spin!");
        one.setBounds(root.width, root.height, 100, 20);
        five.setBounds(root.width, root.height + 25, 100, 20);
        ten.setBounds(root.width, root.height + 50, 100, 20);
        spin.setBounds(root.width, root.height + 75, 100, 20);
        add(one);
        add(five);
        add(ten);
        add(spin);
        one.addActionListener(this);
        five.addActionListener(this);
        ten.addActionListener(this);
        spin.addActionListener(this);
    }

    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        sm.drawMe(g);
    }

    public void actionPerformed(ActionEvent e) {
        // Which Button was pressed
        if(e.getSource() == one) {
            sm.bet(1);
        } else if(e.getSource() == five) {
            sm.bet(5);
        } else if(e.getSource() == ten) {
            sm.bet(10);
        } else if(e.getSource() == spin) {
            sm.play();
        }

        repaint();
    }
}