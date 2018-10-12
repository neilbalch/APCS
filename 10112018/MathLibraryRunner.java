import java.util.Scanner;

public class MathLibraryRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Gimme a quadratic:");
        System.out.print("a: ");
        double a = sc.nextDouble();
        System.out.print("b: ");
        double b = sc.nextDouble();
        System.out.print("c: ");
        double c = sc.nextDouble();

        System.out.println();

        MathLibrary.solveQuadratic(a, b, c);
    }
}
