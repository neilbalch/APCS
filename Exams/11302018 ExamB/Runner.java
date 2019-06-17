public class Runner {
	public static void main(String[] args) {
		Exam2 e2 = new Exam2();
		
		System.out.println(e2.getScore(5, 7));
		e2.count(5, 10);
		
		int[] numArray = new int[5];
		for(int i = 0; i < numArray.length; i++)
			numArray[i] = (int)(Math.random() * 5 + 1);
		e2.printArray(numArray);
		System.out.println(e2.sumArray(numArray));
	}
}