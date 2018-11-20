import java.util.Scanner;

public class Formulas {
    public void coneVolume() {
        System.out.println("*Volume of a Cone*");

        System.out.print("Please enter a base radius: ");
        double radius = sc.nextDouble();

        System.out.print("Next, please enter a height: ");
        double height = sc.nextDouble();

        double volume = (Math.pow(radius, 2) * pi * height) / 3.0;
        System.out.println("The volume of this cone is: " + volume);
    }

    public void sphereVolume() {
        System.out.println("*Volume of a Sphere*");

        System.out.print("Please enter a radius: ");
        double radius = sc.nextDouble();

        double volume = (4.0 * pi * Math.pow(radius, 3)) / 3.0;
        System.out.println("The volume of this sphere is: " + volume);
    }

    public void cubeVolume() {
        System.out.println("*Volume of a Cube*");

        System.out.print("Please enter a side length: ");
        double side = sc.nextDouble();

        double volume = Math.pow(side, 3);
        System.out.println("The volume of this cube is: " + volume);
    }

    public void rectangularPrisimVolume() {
        System.out.println("*Volume of a Rectangular Prism*");

        System.out.print("Please enter a base length: ");
        double base1 = sc.nextDouble();

        System.out.print("Next, please enter another base length: ");
        double base2 = sc.nextDouble();

        System.out.print("Next, please enter a height: ");
        double height = sc.nextDouble();

        double volume = base1 * base2 * height;
        System.out.println("The volume of this rectangular prism is: " + volume);
    }

    public void cylindereVolume() {
        System.out.println("*Volume of a Cylinder*");

        System.out.print("Please enter a base radius: ");
        double radius = sc.nextDouble();

        System.out.print("Next, please enter a height: ");
        double height = sc.nextDouble();

        double volume = height * pi * Math.pow(radius, 2);
        System.out.println("The volume of this cylinder is: " + volume);
    }

    public void circleArea() {
        System.out.println("*Area of a Circle*");

        System.out.print("Please enter a radius: ");
        double radius = sc.nextDouble();

        double area = pi * Math.pow(radius, 2);
        System.out.println("The area of this circle is: " + area);
    }

    public void squareArea() {
        System.out.println("*Area of a Square*");

        System.out.print("Please enter a side length: ");
        double side = sc.nextDouble();

        double area = Math.pow(side, 2);
        System.out.println("The area of this square is: " + area);
    }

    public void rectangleArea() {
        System.out.println("*Area of a Rectangle*");

        System.out.print("Please enter a side length: ");
        double side1 = sc.nextDouble();

        System.out.print("Please enter another side length: ");
        double side2 = sc.nextDouble();

        double area = side1 * side2;
        System.out.println("The area of this rectangle is: " + area);
    }

    public void triangleArea() {
        System.out.println("*Area of a Triangle*");

        System.out.print("Please enter a base length: ");
        double base = sc.nextDouble();

        System.out.print("Please enter a height: ");
        double height = sc.nextDouble();

        double area = base * height / 2.0;
        System.out.println("The area of this triangle is: " + area);
    }

    public void ellipseArea() {
        System.out.println("*Area of an Ellipse*");

        System.out.print("Please enter a minor radius: ");
        double radius1 = sc.nextDouble();

        System.out.print("Please enter a major radius: ");
        double radius2 = sc.nextDouble();

        double area = pi * radius1 * radius2;
        System.out.println("The area of this ellipse is: " + area);
    }

    public void linearMomentum() {
        System.out.println("*Linear Momentum*");

        System.out.print("Please enter the object's mass: ");
        double m = sc.nextDouble();

        System.out.print("Please enter the object's velocity: ");
        double v = sc.nextDouble();

        double p = m * v;
        System.out.println("The linear momentum of this object is: " + p);
    }

    public void heightOfFallingObject() {
        System.out.println("*Height of a Falling Object (given no air resistance)*");

        System.out.print("Please enter the object's initial height: ");
        double x_0 = sc.nextDouble();

        System.out.print("Please enter the object's initial velocity: (enter positive) ");
        double v_0 = sc.nextDouble();

        System.out.print("Please enter the time from t=0: ");
        double t = sc.nextDouble();

        double x = x_0 - x_0 * t - a_g / 2.0 * Math.pow(t, 2);
        System.out.println("The height of this falling object object is: " + x);
    }

    public void velocityOfFallingObject() {
        System.out.println("*Velocity of Falling Object*");

        System.out.print("Please enter the time since t=0: ");
        double t = sc.nextDouble();

        double v = -1 * t * a_g;
        System.out.println("The velocity of this falling object is: " + v);
    }

    public void positionFormula() {
        System.out.println("*Position Formula*");

        System.out.print("Please enter the object's velocity: ");
        double v = sc.nextDouble();

        System.out.print("Please enter the time since t=0: ");
        double t = sc.nextDouble();

        double p = t * v;
        System.out.println("The position of this falling object is: " + p);
    }

    public void angularSpeed() {
        System.out.println("*Angular Speed*");

        System.out.print("Please enter the object's initial angular speed: ");
        double w_0 = sc.nextDouble();

        System.out.print("Please enter the object's angular acceleration: ");
        double a = sc.nextDouble();

        System.out.print("Please enter the time since t=0: ");
        double t = sc.nextDouble();

        double w = w_0 + a * t;
        System.out.println("The angular speed of this object is: " + w);
    }

    private Scanner sc = new Scanner(System.in);

    private double pi = 3.14;
    private double a_g = 9.81;
}
