import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Triangle Area!!!");
        System.out.print("Please type in the base length of a triangle: ");
        double base = sc.nextDouble();
        System.out.print("Please type in the height of a triangle: ");
        double height = sc.nextDouble();

        System.out.println("The area of this triangle you mysteriously pulled out of your butt is: " + (0.5 * base * height));
    }
}
