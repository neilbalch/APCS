/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String[] ranks = {"1", "10", "K"};
		String[] suits = {"spades", "hearts", "spades"};
		int[] values = {1, 10, 13};
	    Deck d1 = new Deck(ranks, suits, values);
		Deck d2 = new Deck(ranks, suits, values);
		Deck d3 = new Deck(ranks, suits, values);

		System.out.println(d1.isEmpty());
		System.out.println(d2.isEmpty());
		System.out.println(d3.isEmpty());

		d1.shuffle();
		d2.shuffle();
		d3.shuffle();

		d1.deal();
		d2.deal();
		d3.deal();

		System.out.println();
		System.out.println(d1.size());
		System.out.println(d2.size());
		System.out.println(d3.size());
	}
}
