/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
	    Card c1 = new Card("J", "spades", 11);
		Card c2 = new Card("3", "hearts", 3);
		Card c3 = new Card("7", "clubs", 7);

		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);

		System.out.println(c1.suit());
		System.out.println(c2.suit());
		System.out.println(c3.suit());

		System.out.println(c1.rank());
		System.out.println(c2.rank());
		System.out.println(c3.rank());

		System.out.println(c1.pointValue());
		System.out.println(c2.pointValue());
		System.out.println(c3.pointValue());

		System.out.println(c1.matches(c2));
		System.out.println(c2.matches(c3));
		System.out.println(c3.matches(c1));
	}
}
