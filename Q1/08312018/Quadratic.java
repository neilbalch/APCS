import java.util.Scanner;

public class Quadratic {
    public static void main(String[] args) {
        double a = 0;
        double b = 0;
        double c = 0;

        Scanner reader = new Scanner(System.in);
        System.out.println("Please enter the coefficients to a quadratic function.");
        System.out.print("a: ");
        a = reader.nextInt();
        System.out.print("b: ");
        b = reader.nextInt();
        System.out.print("c: ");
        c = reader.nextInt();

        double x1 = (-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / 2 * a;
        double x2 = (-b - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / 2 * a;

        System.out.println("\nThe solutions to that quadratic are: x=" + x1 + "," + x2);

        reader.close();
    }
}
