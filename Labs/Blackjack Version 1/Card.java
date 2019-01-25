import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

public class Card {
    private int value;
    private String suit;

    public Card(int value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getValue() { return value; }

    public void drawMe(Graphics g, Dimension root) {
        // Card outline
        g.setColor(Color.WHITE);
        g.fillRoundRect(root.width, root.height, 120, 150, 10, 10);
        g.setColor(Color.BLACK);
        g.drawRoundRect(root.width, root.height, 120, 150, 10, 10);

        // Draw card value
        g.setFont(new Font("Arial", Font.PLAIN, 50));
        int label_offset_x = 5;
        int label_offset_y = 30;

        if(suit.equals("H") || suit.equals("D")) {
            g.setColor(Color.RED);

            g.setFont(new Font("Arial", Font.PLAIN, 36));
            if(suit.equals("H")) {
                String valueString;
                if(value > 10 || value == 0) {
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
                        default: // Value must be 0 b POE.
                            valueString = "A";
                            break;
                    }
                } else valueString = Integer.toString(value);
                g.drawString(valueString + "♥", root.width + 35, root.height + 95);
                g.drawString("♥", root.width + label_offset_x, root.height + label_offset_y);
            } else {
                String valueString;
                if(value > 10 || value == 0) {
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
                        default: // Value must be 0 b POE.
                            valueString = "A";
                            break;
                    }
                } else valueString = Integer.toString(value);
                g.drawString(valueString + "♦", root.width + 35, root.height + 95);
                g.drawString("♦", root.width + label_offset_x, root.height + label_offset_y);
            }
        } else if(suit.equals("C") || suit.equals("S")) {
            g.setColor(Color.BLACK);

            g.setFont(new Font("Arial", Font.PLAIN, 36));
            if(suit.equals("C")) {
                String valueString;
                if(value > 10 || value == 0) {
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
                        default: // Value must be 0 b POE.
                            valueString = "A";
                            break;
                    }
                } else valueString = Integer.toString(value);
                g.drawString(valueString + "♣", root.width + 35, root.height + 95);
                g.drawString("♣", root.width + label_offset_x, root.height + label_offset_y);
            } else {
                String valueString;
                if(value > 10 || value == 0) {
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
                        default: // Value must be 0 b POE.
                            valueString = "A";
                            break;
                    }
                } else valueString = Integer.toString(value);
                g.drawString(valueString + "♠", root.width + 35, root.height + 95);
                g.drawString("♠", root.width + label_offset_x, root.height + label_offset_y);
            }
        }
    }
}