import java.util.Scanner;

public class Cylinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter in the base radius of a cyinder: ");
        double radius = sc.nextDouble();
        System.out.print("Now, please enter the height of a cylinder: ");
        double height = sc.nextDouble();

        System.out.println("Alright, the volume of the cylinder you specified is: " + (Math.PI * Math.pow(radius, 2) * height));
    }
}