import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Table extends JPanel implements ActionListener {
    private Card[] deck;
    private int playerIndex; // Now many cards the player has dealt out.
    private int points;
    private JButton hitButton;
    private JButton standButton;
    private JButton newGameButton;
    private boolean gameLost;

    public Table(){
        setLayout(null);
        hitButton = new JButton("Hit");
        hitButton.setBounds(150, 50, 75, 30);
        hitButton.addActionListener(this);
        add(hitButton);

        standButton = new JButton("Stand");
        standButton.setBounds(250, 50, 75, 30);
        standButton.addActionListener(this);
        add(standButton);

        newGameButton = new JButton("Start New Game");
        newGameButton.setBounds(350, 50, 150, 30);
        newGameButton.addActionListener(this);
        add(newGameButton);

        reset(false);
    }

    private void reset(boolean preservePoints) {
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

        if(!preservePoints) points = 20;
        gameLost = false;
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
                y_pos += 175;
            }

            if(deck[i].getValue() < 10) score += deck[i].getValue();
            else score += 10;
        }

        g.setFont(new Font("Arial", Font.PLAIN, 28));
        g.setColor(Color.BLACK);
        g.drawString("Score: " + score, 10, 30);
        g.drawString("Points: " + points, 150, 30);

        if(score > 21) {
            gameLost = true;
            add(newGameButton);
        } else if(score == 21) {

        }

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

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == hitButton) {
            if(!gameLost) {
                playerIndex++;
                repaint();
            }
        } else if(e.getSource() == standButton) {

        } else if(e.getSource() == newGameButton) {
            // complete reset...
            points--;
            reset(true);
            remove(newGameButton);
            repaint();
        }
    }
}
