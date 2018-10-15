public class MathLibrary {
    private double pi;

    public MathLibrary() {
        pi = Math.PI;
    }

    public double areaCircle(double radius) {
        return pi * Math.pow(radius, 2);
    }

    public double volCylinder(double radius, double height) {
        return height * areaCircle(radius);
    }

    public double volCone(double radius, double height) {
        return areaCircle(radius) * height / 3.0;
    }
}
