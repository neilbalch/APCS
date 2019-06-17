public class Exam2 {
	private double pi;
	private double radius;
	
	public Exam2() {
		pi = 3.14;
		radius = 10;
	}
	
	public Exam2(double radius) {
		pi = 3.14;
		this.radius = radius;
	}
	
	public void printCirc() {
		System.out.println("The circumference of the circle specified is: " + 2 * pi * radius);
	}
	
	public void printVolCone(double height) {
		System.out.println("The volume of the cone specified is: " + (1.0/3.0) * pi * Math.pow(radius, 2) * height);
	}
}