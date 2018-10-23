import java.util.Scanner;

public class WhileDemo {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int i = 0;

        i = 1;
        while(i <= 12) {
            System.out.print(i + " ");
            i++;
        }
        System.out.print("\n");
        System.out.println("/////////////////////");

        i = 5;
        while(i <= 31) {
            System.out.print(i + " ");
            i++;
        }
        System.out.print("\n");
        System.out.println("/////////////////////");

        i = 39;
        while(i >= 21) {
            System.out.print(i + " ");
            i--;
        }
        System.out.print("\n");
        System.out.println("/////////////////////");

        i = 2;
        while(i <= 21) {
            System.out.print(i + " ");
            i += 2;
        }
        System.out.print("\n");
        System.out.println("/////////////////////");

        i = 15;
        while(i >= -10) {
            System.out.print(i + " ");
            i -= 5;
        }
        System.out.print("\n");
        System.out.println("/////////////////////");

        System.out.print("To what number should I count? ");
        int num = sc.nextInt();
        System.out.print("By what step should I count from ");
        int step = sc.nextInt();

        i = 1;
        while(i <= num) {
            System.out.print(i + " ");
            i += step;
        }
        System.out.print("\n");
        System.out.println("/////////////////////");


        System.out.println("\n\nPART 2\n\n");


        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        System.out.println("/------------------\\");
        for(int j = 0; j < number - 2; j++) {
            System.out.println("|******************|");
        }
        System.out.println("\\------------------/");

        System.out.print("Enter a number: ");
        number = sc.nextInt();

        int total = 0;
        for(int k = 1; k <= number; k ++) {
            total += k;
        }
        System.out.println("Sum of all numbers from 1 to " + number + " is: " + total);
    }
}