import java.util.ArrayList;

public class Runner {
	public static void main(String[] args) {
		ArrayListQuiz2 aq = new ArrayListQuiz2();
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(new Student(1234, "John"));
		students.add(new Student(3333, "Jen"));
		students.add(new Student(1111, "Jose"));
		students.add(new Student(4321, "Jane"));
		
		aq.printList(students);
		System.out.println("Scramble");
		aq.scramble(students);
		aq.printList(students);
		System.out.println("Sort");
		aq.sort(students);
		aq.printList(students);
	}
}