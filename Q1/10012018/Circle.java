public class Circle {
    private double pi;
    private double radius;

    public Circle() {
        radius = 0;
        pi = 3.14;
    }

    public Circle(double radius) {
        this.radius = radius;
        pi = 3.14;
    }

    public void printCylinderVol(double height) {
        System.out.println("Volume of this cylinder is: " + (height * pi * Math.pow(radius, 2)));
    }
}