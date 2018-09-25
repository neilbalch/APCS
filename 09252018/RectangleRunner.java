import java.util.Scanner;

public class RectangleRunner {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        r1.printArea();

        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter a rectangle length: ");
        int length = sc.nextInt();
        System.out.print("Please enter a rectangle width: ");
        int width = sc.nextInt();

        Rectangle r2 = new Rectangle(length, width);
        r2.printArea();
    }
}
