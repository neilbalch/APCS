import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class GameState {
    public ArrayList<Card> deck;
    public ArrayList<Card> playerHand;
    public ArrayList<Card> dealerHand;

    public enum State {INPLAY, LOST, WON, TIED};
    public State state;

    public int playerWins;
    public int dealerWins;

    public GameState() {
        deck = new ArrayList<Card>();
        playerHand = new ArrayList<Card>();
        dealerHand = new ArrayList<Card>();
        state = State.INPLAY;
        playerWins = 0;
        dealerWins = 0;
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
//    private GameState previousState;
    private GameState state;

    private JButton hitButton;
    private JButton standButton;
    private JButton newGameButton;

    // Shuffle the deck
    private void dealAndShuffle(){
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
        state = new GameState();

        dealAndShuffle();

        // Clear dealer and player hands
        state.playerHand.clear();
        state.dealerHand.clear();

        // Get all the buttons configured
        Dimension root = new Dimension(15, 15);

        hitButton = new JButton("Hit");
        hitButton.setBounds(root.width, root.height, 75, 30);
        hitButton.addActionListener(this);
        add(hitButton);
        hitButton.setEnabled(false);

        standButton = new JButton("Stand");
        standButton.setBounds(root.width + 85, root.height, 75, 30);
        standButton.addActionListener(this);
        add(standButton);
        standButton.setEnabled(false);

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

        // Show Dealer's hand
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 18));
        g.drawString("Dealer's Hand Score: " + state.getDealerScore() + "   Wins: " + state.dealerWins, 25, 70);
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

        // Show player's hand
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 18));
        g.drawString("Player's Hand Score: " + state.getPlayerScore() + "   Wins: " + state.playerWins, 25, 275);
        {
            int x_pos = 25;
            int y_pos = 290;
            for (int i = 0; i < state.playerHand.size(); i++) {
                state.playerHand.get(i).drawMe(g, new Dimension(x_pos, y_pos));

                if (x_pos < 650) x_pos += 85;
                else {
                    x_pos = 25;
                    y_pos += 175;
                }
            }
        }

        // Display game status... won, lost, tied...
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 28));
        String toPrint = "";
        switch(state.state) {
            case WON:
                toPrint = "Congratulations, you won!";
                state.playerWins++;
                break;
            case LOST:
                toPrint = "Wah, Wah. You lost.";
                state.dealerWins++;
                break;
            case TIED:
                toPrint = "Well, looks like a Mexican Standoff";
                break;
            case INPLAY:
                break;
        }
        g.drawString(toPrint, 300, 550);
    }

    private void handleStand() {
        // Make the dealer's card visible
        state.dealerHand.get(0).setFlipped(false);

        // Dealer gets new cards
        while(state.getDealerScore() < 17) {
            state.dealerHand.add(state.deck.get(0));
            state.deck.remove(0);
        }

        if(state.getDealerScore() > 21) { state.state = GameState.State.WON; }
        else if(state.getPlayerScore() == state.getDealerScore()) { state.state = GameState.State.TIED; }
        else if(state.getPlayerScore() > state.getDealerScore()) { state.state = GameState.State.WON; }
        else { state.state = GameState.State.LOST; }
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == hitButton && state.state == GameState.State.INPLAY) {
            state.playerHand.add(state.deck.get(0));
            state.deck.remove(0);

            if(state.getPlayerScore() == 21) {
                handleStand();
            } else if(state.getPlayerScore() > 21) { // Player Loses
                state.state = GameState.State.LOST;
            }
        } else if(e.getSource() == standButton) {
            // Make the button clickable
            newGameButton.setEnabled(true);
            handleStand();
        } else if(e.getSource() == newGameButton) {
            state.playerHand.clear();
            state.dealerHand.clear();

            dealAndShuffle();

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

            state.state = GameState.State.INPLAY;
        }

        // Show/hide buttons according to game state
        if(state.state != GameState.State.INPLAY) {
            newGameButton.setEnabled(true);
            hitButton.setEnabled(false);
            standButton.setEnabled(false);
        } else {
            newGameButton.setEnabled(false);
            hitButton.setEnabled(true);
            standButton.setEnabled(true);
        }

        // No matter what, must repaint
        repaint();
    }
}
