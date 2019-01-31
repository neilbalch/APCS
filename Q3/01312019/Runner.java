import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        ArrayList<Card> deck = new ArrayList<Card>();
        for(int i = 0; i < 10; i++) {
            deck.add(new Card((int)(5 * Math.random() + 1)));
        }

        System.out.println();
        for(Card c : deck) System.out.println(c);

        for(int i = 0; i < deck.size(); i++) {
            if(deck.get(i).getValue() == 5) {
                deck.remove(i);
                i--;
            }
        }

        System.out.println();
        for(Card c : deck) System.out.println(c);

        for(int i = 0; i < deck.size(); i++) {
            if(deck.get(i).getValue() == 1) {
                deck.set(i, new Card(99));
            }
        }

        System.out.println();
        for(Card c : deck) System.out.println(c);
    }
}