public class MathLibrary {
    public static void solveQuadratic(double a, double b, double c) {
        if((Math.pow(b,2) - 4 * a * c) < 0) {
            System.out.println("Err: Nonreal solutions");
            return;
        }

        double x_1 = (-b + Math.sqrt(Math.pow(b, 2) - 4*a*c)) / (2 * a);
        double x_2 = (-b - Math.sqrt(Math.pow(b, 2) - 4*a*c)) / (2 * a);

        System.out.println("Solutions: " + x_1 + " and " + x_2);
    }
}
