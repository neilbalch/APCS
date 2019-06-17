import java.util.ArrayList;

public class ArrayListQuiz2 {
	public void printList(ArrayList<Student> list) {
		for(Student each : list) {
			System.out.println(each);
		}
	}
	
	public void scramble(ArrayList<Student> list) {
		for(int i = 0; i < list.size(); i++) {
			int index2 = (int)(list.size() * Math.random());
			
			Student temp = list.get(i);
			list.set(i, list.get(index2));
			list.set(index2, temp);
		}
	}
	
	public void sort(ArrayList<Student> list) {
		for(int i = 0; i < list.size() - 1; i++) {
			for(int j = i + 1; j < list.size(); j++) {
				if(list.get(i).getID() > list.get(j).getID()) {
					Student temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}
	}
}