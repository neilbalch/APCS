public class MathQuiz2 {
	private double pi;
	private double radius;
	
	public MathQuiz2(double radius) {
		this.pi = 3.14;
		this.radius = radius;
	}
	
	public double getArea() {
		return pi * Math.pow(radius, 2);
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
}