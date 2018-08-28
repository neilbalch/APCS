import java.util.Scanner;

public class Mess {
    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("I will be finding the area of circle. Please give a radius.");

        double radius = keyboard.nextDouble();
        double M_PI = 3.14;
        double area = M_PI * radius * radius;

        System.out.println("The area of this circle is " + area);

        System.out.println("------------------------------------------------");

        System.out.println("I will find the area of a square. Please give a side length.");

        double side = keyboard.nextDouble();
        double s_area = side * side;

        System.out.println("The area of this square is " + s_area);
    }
}
