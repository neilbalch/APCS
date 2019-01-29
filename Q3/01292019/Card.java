public class Card {
   private int value;
   private String suit;

   public Card(int value, String suit) {
       this.value = value;
       this.suit = suit;
   }

   public String toString() {
       return "Value: " + Integer.toString(value) + " , Suit: " + suit;
   }
}