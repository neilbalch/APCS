public class Radius {
    private double pi = Math.PI;

    public void printArea(double radius) {
        System.out.println("Area of a circle with radius=" + radius + " is: " + (pi * Math.pow(radius, 2)));
    }

    public void printCir(double radius) {
        System.out.println("Circumference of a circle with radius=" + radius + " is: " + (2 * pi * radius));
    }

    public void printConeVolume(double radius, double height) {
        System.out.println("Volume of a cone with radius=" + radius + " and height=" + height + " is: " + (height / 3.0 * pi * Math.pow(radius, 2)));
    }
}
