import java.util.Scanner;

public class MathLibraryRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MathLibrary ml = new MathLibrary();

        System.out.print("Radius? ");
        System.out.println(ml.areaCircle(sc.nextDouble()));
        System.out.print("Radius? ");
        double radius = sc.nextDouble();
        System.out.print("Height? ");
        double height = sc.nextDouble();
        System.out.println(ml.volCylinder(radius, height));
        System.out.print("Radius? ");
        radius = sc.nextDouble();
        System.out.print("Height? ");
        height = sc.nextDouble();
        System.out.println(ml.volCone(radius, height));
    }
}
