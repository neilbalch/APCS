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
    private int lastPayout;
    private JButton hitButton;
    private JButton standButton;
    private JButton newGameButton;
    private enum GameState {LOST, INPLAY, WON};
    private GameState gameState;

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
//        add(newGameButton); // Only add when game is lost

        reset(false);
    }

    private void reset(boolean preservePoints) {
        deck = new Card[52];
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 13; j++) {
                String suit;
                if(i == 0) suit = "C";
                else if(i == 1) suit = "D";
                else if(i == 2) suit = "H";
                else suit = "S";

                deck[13 * i + j] = new Card(j + 2, suit);
            }
        }

        shuffle();

        if(!preservePoints) {
            points = 20;
            lastPayout = 0;
        }
        gameState = GameState.INPLAY;
        playerIndex = 2;
    }

    public Dimension getPreferredSize() {
        //Sets the size of the panel
        return new Dimension(1000,600);
    }

    private int getPlayerScore() {
        int score = 0;
        int numAces = 0;

        for(int i = 0; i < playerIndex; i++) {
            if(deck[i].getValue() < 10) score += deck[i].getValue();
            else if(deck[i].getValue() == 14) {
                // it's an ace
                score += 11;
                numAces++;
            } else score += 10;
        }

        // If the score is big, then Aces will effectively equal 1 score point
        if(score > 21) score -= (numAces * 10);

        return score;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.green);
        g.fillRect(0,0,1000,600);

        int x_pos = 100;
        int y_pos = 100;
        for(int i = 0; i < playerIndex; i++) {
            deck[i].drawMe(g, new Dimension(x_pos, y_pos));
            if(x_pos < 650) x_pos += 150;
            else {
                x_pos = 100;
                y_pos += 175;
            }
        }

        int score = getPlayerScore();
        if(score > 21) {
            gameState = GameState.LOST;
            lastPayout = 0;
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.PLAIN, 36));
            g.drawString("You Lose! Start a new game.", 450, 35);
            add(newGameButton);
        }

        g.setFont(new Font("Arial", Font.PLAIN, 28));
        g.setColor(Color.BLACK);
        g.drawString("Score: " + score, 10, 30);
        g.drawString("Points: " + points, 150, 30);

        if(lastPayout != 0) { g.drawString("Payout: " + lastPayout, 325, 30); }
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

    private void handleStand(int score) {
        // Decide on final score bump
        if(score <= 15) { // player gets no points
        } else if(score <= 18) { // score >= 16 is implied from previous statement
            gameState = GameState.WON;
            points += 1;
            lastPayout = 1;
        } else if(score == 19) {
            gameState = GameState.WON;
            points += 2;
            lastPayout = 2;
        } else if(score == 20) {
            gameState = GameState.WON;
            points += 3;
            lastPayout = 3;
        } else if(score == 21) {
            gameState = GameState.WON;
            points += 5;
            lastPayout = 5;
        }

        // New game is started, follow same protocol
        points--;
        reset(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == hitButton && gameState == GameState.INPLAY) {
            playerIndex++;
            if(getPlayerScore() == 21) handleStand(21);
        } else if(e.getSource() == standButton && gameState == GameState.INPLAY) {
            if(points > 0) {
                handleStand(getPlayerScore());
            } else add(newGameButton);
        } else if(e.getSource() == newGameButton && points > 0) {
            // complete reset...
            points--;
            reset(true);
            remove(newGameButton);
        }

        // No matter what, must repaint
        repaint();
    }
}
