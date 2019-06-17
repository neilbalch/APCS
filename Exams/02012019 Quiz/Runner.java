import java.util.ArrayList;

public class Runner {
	public static void main(String[] args) {
		ArrayQuiz aq = new ArrayQuiz();
		ArrayList<Integer> numList = new ArrayList<Integer>();
		for(int i = 0; i < 5; i++) {
			numList.add(new Integer((int)(5 * Math.random() + 1)));
		}
		
		aq.printList(numList);
		System.out.println("Search and delete");
		aq.searchAndDelete(numList, 2);
		aq.printList(numList);
		System.out.println("Search and replace");
		aq.searchAndReplace(numList, 4);
		aq.printList(numList);
	}
}