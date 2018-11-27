import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Screen extends JPanel implements KeyListener {
    private Projectile p1;
    private Ship s1;
    private Enemy[] enemies;

    public Screen() {
        s1 = new Ship(50,300);
        p1 = new Projectile(75,350);

        enemies = new Enemy[10];
        for(int i = 0; i < enemies.length; i++) {
            if(i%3 == 0)
                enemies[i] = new Enemy((int)(400 * Math.random() + 300), (int)(500 * Math.random()), new Color(247, 54, 33));
            if(i%3 == 1)
                enemies[i] = new Enemy((int)(400 * Math.random() + 300), (int)(500 * Math.random()), new Color(7, 255, 0));
            if(i%3 == 2)
                enemies[i] = new Enemy((int)(400 * Math.random() + 300), (int)(500 * Math.random()), new Color(148, 35, 255));
        }

        //sets keylistener
        setFocusable(true);
        addKeyListener(this);
    }

    public Dimension getPreferredSize() {
        //Sets the size of the panel
        return new Dimension(800,600);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.white);
        g.fillRect(0, 0, 800, 600);


        //Draw ship
        s1.drawMe(g);

        for(int i = 0; i < enemies.length; i++) {
            enemies[i].drawMe(g);
        }

        //Draw Projectile
        p1.drawMe(g);
    }


    public void animate() {
        while(true) {
            //wait for .01 second
            try {
                Thread.sleep(10);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            p1.move(3, 0);
            for(int i = 0; i < enemies.length; i++)
                enemies[i].checkCollision(p1);

            //repaint the graphics drawn
            repaint();
        }
    }

    //implement methods of the KeyListener
    public void keyPressed(KeyEvent e) {
        //key codes: http://www.cambiaresearch.com/articles/15/javascript-char-codes-key-codes

        if (e.getKeyCode()==38){ //Up Arrow
            s1.moveUp();
        } else if (e.getKeyCode()==40){ //Down Arrow
            s1.moveDown();
        } else if(e.getKeyCode() == 32) { // Spacebar
            //Shoot projectile
            if(!p1.getVisibility()) {
                p1.setVisiblity(true);
                p1.reset(50, 300);
                p1.move(0, s1.getY() - p1.getY());
            }
        }

        repaint();
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}