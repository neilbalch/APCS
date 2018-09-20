import java.util.Scanner;

public class Circle {
    private double pi = Math.PI;
    private double radius = 0;
    private Scanner sc = new Scanner(System.in);

    public void setRadius() {
        System.out.print("Please enter the radius of a circle: ");
        radius = sc.nextDouble();
    }

    public void printArea() {
        System.out.println("The area of a circle with radius=" + radius + " is: " + (pi * Math.pow(radius, 2)));
    }
}