public class Circle2 {
    private double pi;
    private double radius;

    public Circle2() {
        pi = 3.14;
        radius = 1;
    }

    public Circle2(double radius) {
        pi = 3.14;
        this.radius = radius;
    }

    public void printArea() {
        System.out.println("Area: " + (pi * Math.pow(radius, 2)));
    }

    public void printArea(double radius) {
        System.out.println("Area: " + (pi * Math.pow(radius, 2)));
    }
}
