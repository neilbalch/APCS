import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

public class Card {
    private int value;
    private boolean flipped;
    private String suit;

    public Card(int value, String suit, boolean flipped) {
        this.value = value;
        this.suit = suit;
        this.flipped = flipped;
    }

    public int getValue() { return value; }

    public void setFlipped(boolean flipped) { this.flipped = flipped; }

    public String toString() { return value + suit; }

    public void drawMe(Graphics g, Dimension root) {

        // Card outline
        g.setColor(Color.WHITE);
        g.fillRoundRect(root.width, root.height, 120, 150, 10, 10);
        g.setColor(Color.BLACK);
        g.drawRoundRect(root.width, root.height, 120, 150, 10, 10);

        // Don't draw anything else if the card is flipped
        if(flipped) return;

        // Draw card value
        g.setFont(new Font("Arial", Font.PLAIN, 50));
        int label_offset_x = 5;
        int label_offset_y = 30;

        // Sort out what value to print on this card
        String valueString;
        if(value > 10 || value == 1) {
            switch(value) {
                case 11:
                    valueString = "J";
                    break;
                case 12:
                    valueString = "Q";
                    break;
                case 13:
                    valueString = "K";
                    break;
                default: // Value must be 1 b POE.
                    valueString = "A";
                    break;
            }
        } else valueString = Integer.toString(value);

        // Peremptorily set font for future use
        g.setFont(new Font("Arial", Font.PLAIN, 36));

        String suitChar;
        if(suit.equals("H")) {
            // H and D are red suits
            g.setColor(Color.RED);
            suitChar = "♥";
        } else if(suit.equals("D")) {
            // H and D are red suits
            g.setColor(Color.RED);
            suitChar = "♦";
        } else if(suit.equals("C")) {
            // C ands S are black suits
            g.setColor(Color.BLACK);
            suitChar = "♣";
        } else { // suit.equals("S")
            // C ands S are black suits
            g.setColor(Color.BLACK);
            suitChar = "♠";
        }

        // Print strings to screen
        g.drawString(valueString + suitChar, root.width + 35, root.height + 95);
        g.drawString(suitChar, root.width + label_offset_x, root.height + label_offset_y);
    }
}