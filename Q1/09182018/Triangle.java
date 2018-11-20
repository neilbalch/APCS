import java.util.Scanner;

public class Triangle {
    public void printArea() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter the base length of a triangle: ");
        double base = sc.nextDouble();

        System.out.print("Now please enter the height of a triangle: ");
        double height = sc.nextDouble();

        System.out.println("The area of that triangle is: " + (0.5 * base * height));
    }
}