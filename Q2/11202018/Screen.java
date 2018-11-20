import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Screen extends JPanel implements KeyListener {
    private Player player1;

    public Screen() {
        setFocusable(true);
        addKeyListener(this);

        player1 = new Player(50, 300);
    }

    //Sets the size of the panel
    public Dimension getPreferredSize() {
        return new Dimension(800,600);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        player1.drawPlayer(g);
    }

    public void keyPressed(KeyEvent e) {
        //System.out.println(e.getKeyCode());
        switch (e.getKeyCode()) {
            case 38: // Up
                player1.movePlayer(0, 5);
                repaint();
                break;
            case 40: // Down
                player1.movePlayer(0, -5);
                repaint();
                break;
            case 39: // Right
                player1.movePlayer(5, 0);
                repaint();
                break;
            case 37: // Left
                player1.movePlayer(-5, 0);
                repaint();
                break;
        }
        switch (e.getKeyChar()) {
            case 'w': // Up
                player1.movePlayer(0, 5);
                repaint();
                break;
            case 's': // Down
                player1.movePlayer(0, -5);
                repaint();
                break;
            case 'd': // Right
                player1.movePlayer(5, 0);
                repaint();
                break;
            case 'a': // Left
                player1.movePlayer(-5, 0);
                repaint();
                break;
        }
    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }
}