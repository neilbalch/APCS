import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Table extends JPanel{
    private Card[] deck;
    private int playerIndex; // Now many cards the player has dealt out.
    private int points;

    public Table(){
        setLayout(null);
        deck = new Card[52];
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 13; j++) {
                if(i == 0) deck[13 * i + j] = new Card(j + 1, "C");
                else if(i == 1) deck[13 * i + j] = new Card(j + 1, "D");
                else if(i == 2) deck[13 * i + j] = new Card(j + 1, "H");
                else deck[13 * i + j] = new Card(j + 1, "S");
            }
        }

        shuffle();

        points = 21;
        playerIndex = 2;
    }

    public Dimension getPreferredSize() {
        //Sets the size of the panel
        return new Dimension(1000,600);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.green);
        g.fillRect(0,0,1000,600);

        int score = 0;

        int x_pos = 100;
        int y_pos = 100;
        for(int i = 0; i < playerIndex; i++) {
            deck[i].drawMe(g, new Dimension(x_pos, y_pos));
            if(x_pos < 650) x_pos += 150;
            else {
                x_pos = 100;
                y_pos += 150;
            }

            if(deck[i].getValue() < 10) score += deck[i].getValue();
            else score += 10;
        }

        g.setFont(new Font("Arial", Font.PLAIN, 28));
        g.setColor(Color.BLACK);
        g.drawString("Score: " + score, 10, 30);
        g.drawString("Points: " + points, 150, 30);
    }

    private void shuffle(){
        //write code to shuffle your deck
        for(int i = 0; i < deck.length; i++) {
            int index2 = (int)(deck.length * Math.random());

            Card temp = deck[i];
            deck[i] = deck[index2];
            deck[index2] = temp;
        }
    }
}
