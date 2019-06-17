import java.util.ArrayList;

public class ArrayQuiz {
	public void printList(ArrayList<Integer> list) {
		for(Integer i : list) System.out.println(i);
	}
	
	public void searchAndDelete(ArrayList<Integer> list, int query) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) == query) {
				list.remove(i);
				i--;
			}
		}
	}
	
	public void searchAndReplace(ArrayList<Integer> list, int query) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) == query) list.set(i, 99);
		}
	}	
}