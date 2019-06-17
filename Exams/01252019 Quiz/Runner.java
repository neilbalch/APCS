public class Runner {
	public static void main(String[] args) {
		ArrayQuiz aq = new ArrayQuiz();
		aq.printList();
		System.out.println("scramble");
		aq.scramble();
		aq.printList();
		System.out.println("sort");
		aq.sort();
		aq.printList();
	}
}