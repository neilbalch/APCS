public class Method2Quiz {
	private double pi = 0;
	private int radius = 0;
	
	public void setVariables() {
		pi = 3.14;
		radius = 10;
	}
	
	public void printSurfaceArea() {
		double sa = 4 * pi * Math.pow(radius, 2);
		System.out.println("The surface area is: " + sa);
	}
}