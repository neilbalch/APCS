import java.util.Scanner;

public class Input {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Please type in your first name: ");
		String fname = sc.next();
		System.out.println("Hello, " + fname + "!");
		
		System.out.println("Triangle");
		System.out.print("Please type in the base length of a triangle: (Integer) ");
		int base = sc.nextInt();
		System.out.print("Please type in the height of a triangle: (Integer) ");
		int height = sc.nextInt();
		
		System.out.println("The area of that triangle is: " + (0.5 * base * height));
		
		System.out.println("Circle");
		System.out.print("Please type in the radius of a circle: ");
		double radius = sc.nextDouble();
		
		System.out.println("The area of that circle is: " + (3.14 * radius * radius));
	}
}