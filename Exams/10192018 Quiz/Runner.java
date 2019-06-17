public class Runner {
	public static void main(String[] args) {
	    MathQuiz2 mq = new MathQuiz2(15);
	
	    double area = mq.getArea();
	    System.out.println(area);
	
	    mq.setRadius(10);
	    area = mq.getArea();
	    System.out.println(area);
	}
}