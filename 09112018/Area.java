import java.util.Scanner;

public class Area {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("This program will find the area of a rectangle. Please enter an integer length: ");
        int length = sc.nextInt();

        System.out.print("Excellent! Now, please enter a decimal width: ");
        double width = sc.nextDouble();

        double area = length * width;

        System.out.println("Great! Now, this is the area of that rectangle: " + area);
    }
}