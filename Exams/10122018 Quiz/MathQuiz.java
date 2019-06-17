public class MathQuiz {
	private int num;
	
	public MathQuiz(int num) {
		this.num = num;
	}
	
	public void isOdd() {
		if(num%2 == 0)
			System.out.println("num is even");
		else
			System.out.println("num is odd");
	}
	
	public void findC(int a, int b) {
		double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
		System.out.println("c is: " + c);
	}
}