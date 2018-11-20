import java.util.Scanner;

public class Birthyear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please type your birth year: ");
        int year = sc.nextInt();

        System.out.println("Your age is approximately: " + (2018 - year));
    }
}
