import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class GameState {
    public ArrayList<Card> deck;
    public ArrayList<Card> playerHand;
    public ArrayList<Card> dealerHand;

    public GameState() {
        deck = new ArrayList<Card>();
        playerHand = new ArrayList<Card>();
        dealerHand = new ArrayList<Card>();
    }

    // Calculate the score of the player's hand
    public int getPlayerScore() {
        int score = 0;
        int numAces = 0;

        for(int i = 0; i < playerHand.size(); i++) {
            if(playerHand.get(i).getValue() < 10) score += playerHand.get(i).getValue(); // If the card isn't a face card, then just add its value to the score
            else if(playerHand.get(i).getValue() == 14) { // If it is an Ace, add 11 and keep track of this fact
                // it's an ace
                score += 11;
                numAces++;
            } else score += 10; // Else, just add 10 for every face card
        }

        // If the score is big, then Aces will effectively equal 1 score point
        if(score > 21) score -= (numAces * 10);

        return score;
    }

    // Calculate the score of the dealer's hand
    public int getDealerScore() {
        int score = 0;
        int numAces = 0;

        for(int i = 0; i < dealerHand.size(); i++) {
            if(dealerHand.get(i).getValue() < 10) score += dealerHand.get(i).getValue(); // If the card isn't a face card, then just add its value to the score
            else if(dealerHand.get(i).getValue() == 14) { // If it is an Ace, add 11 and keep track of this fact
                // it's an ace
                score += 11;
                numAces++;
            } else score += 10; // Else, just add 10 for every face card
        }

        // If the score is big, then Aces will effectively equal 1 score point
        if(score > 21) score -= (numAces * 10);

        return score;
    }
}

public class Table extends JPanel implements ActionListener {
    private GameState previousState;
    private GameState state;

    private JButton hitButton;
    private JButton standButton;
    private JButton newGameButton;

    // Shuffle the deck
    private void shuffle(){
        for(int i = 0; i < state.deck.size(); i++) {
            int index2 = (int)(state.deck.size() * Math.random());

            Card temp = state.deck.get(i);
            state.deck.set(i, state.deck.get(index2));
            state.deck.set(index2, temp);
        }
    }

    public Table(){
        setLayout(null);

        // Initialize state variables
        previousState = new GameState();
        state = new GameState();

        // Fill deck with cards of incrementing suit and size and shuffle them
        state.deck.clear();
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 13; j++) {
                String suit;
                if(i == 0) suit = "C";
                else if(i == 1) suit = "D";
                else if(i == 2) suit = "H";
                else suit = "S";

                state.deck.add(new Card(j + 2, suit, false));
            }
        }
        shuffle();

        // Clear dealer and player hands
        state.playerHand.clear();
        state.dealerHand.clear();

        // Initialize previousState as the current state to start with
        previousState = state;

        // Get all the buttons configured
        Dimension root = new Dimension(15, 15);

        hitButton = new JButton("Hit");
        hitButton.setBounds(root.width, root.height, 75, 30);
        hitButton.addActionListener(this);
        add(hitButton);

        standButton = new JButton("Stand");
        standButton.setBounds(root.width + 85, root.height, 75, 30);
        standButton.addActionListener(this);
        add(standButton);

        newGameButton = new JButton("New Game");
        newGameButton.setBounds(root.width + 170, root.height, 100, 30);
        newGameButton.addActionListener(this);
        add(newGameButton);
    }

    public Dimension getPreferredSize() {
        //Sets the size of the panel
        return new Dimension(1000,600);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        // Set the scene... literally
        g.setColor(Color.green);
        g.fillRect(0,0,1000,600);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 18));
        g.drawString("Dealer's Hand Score: " + state.getDealerScore(), 25, 70);
        { // Empty scope allows me to redefine x_pos and y_pos later
            int x_pos = 25;
            int y_pos = 85;
            for (int i = 0; i < state.dealerHand.size(); i++) {
                state.dealerHand.get(i).drawMe(g, new Dimension(x_pos, y_pos));
                if (x_pos < 650) x_pos += 85;
                else {
                    x_pos = 25;
                    y_pos += 175;
                }
            }
        }

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 18));
        g.drawString("Player's Hand Score: " + state.getPlayerScore(), 25, 275);
        {
            int x_pos = 25;
            int y_pos = 290;
            for (int i = 0; i < state.dealerHand.size(); i++) {
                state.playerHand.get(i).drawMe(g, new Dimension(x_pos, y_pos));
                if (x_pos < 650) x_pos += 85;
                else {
                    x_pos = 25;
                    y_pos += 175;
                }
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == hitButton) {
            state.playerHand.add(state.deck.get(0));
            state.deck.remove(0);

            // The dealer doesn't play if the player busts
            if(state.getPlayerScore() <= 21) {
                state.dealerHand.add(state.deck.get(0));
                state.deck.remove(0);
            }

        } else if(e.getSource() == standButton) {
            // Make the button clickable
            newGameButton.setEnabled(true);

        } else if(e.getSource() == newGameButton) {
            // Add the first two cards in the deck to the player's hand
            state.playerHand.add(state.deck.get(0));
            state.deck.remove(0);
            state.playerHand.add(state.deck.get(0));
            state.deck.remove(0);

            // Add the next two cards in the deck to the dealer's hand
            state.dealerHand.add(state.deck.get(0));
            state.deck.remove(0);
            state.dealerHand.add(state.deck.get(0));
            state.deck.remove(0);
            // Flip the first card in the dealer's hand
            state.dealerHand.get(0).setFlipped(true);

            // Make the button unclickable
            newGameButton.setEnabled(false);
        }

        // No matter what, must repaint
        repaint();
    }
}
