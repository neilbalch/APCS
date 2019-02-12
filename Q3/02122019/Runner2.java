import java.util.ArrayList;

public class Runner2 {
    public static void main(String[] args) {
        Practice pr = new Practice();

        ArrayList<Card> cards = new ArrayList<Card>();
        for(int i = 0; i < 5; i++) {
            cards.add(new Card((int)(5 * Math.random() + 1)));
        }

        pr.print(cards);
        System.out.println(pr.getLargest(cards));
        pr.scramble(cards);
        pr.print(cards);
        pr.sort(cards);
        pr.print(cards);
        pr.searchReplace(1, cards);
        pr.print(cards);
        pr.searchDelete(5, cards);
        pr.print(cards);
    }
}
