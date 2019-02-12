public class Runner1 {
    public static void main(String[] args) {
        Practice pr = new Practice();
        System.out.println(pr.getDomain("jen@mvla.net"));

        Card[] cards = new Card[10];
        for(int i = 0; i < cards.length; i++) {
            cards[i] = new Card((int)(5 * Math.random() + 1));
        }

        pr.print(cards);
        System.out.println(pr.getLargest(cards));
        pr.scramble(cards);
        pr.print(cards);
        pr.sort(cards);
        pr.print(cards);
        pr.searchReplace(2, cards);
        pr.print(cards);
    }
}