import java.util.Scanner;

public class Test {
    private double pi = 0;
    private int radius = 0;

    public void setVariables() {
        pi = 3.14;
        radius = 10;
    }

    public void printCircumference() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter a redius: ");
        radius = sc.nextInt();

        double circumference = 2 * pi * radius;
        System.out.println("The circumference is: " + circumference);
    }
}