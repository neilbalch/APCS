import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter a number (1-3): ");
        int choice = sc.nextInt();
        System.out.println(Menu.selectMenu1(choice));

        System.out.print("Please enter another number (1-3): ");
        choice = sc.nextInt();
        System.out.println(Menu.selectMenu2(choice));

        System.out.print("Please enter assignment scores (1-100): ");
        int score1 = sc.nextInt();
        System.out.print("Again: ");
        int score2 = sc.nextInt();
        System.out.print("One more time: ");
        int score3 = sc.nextInt();
        Grade gr = new Grade(score1, score2, score3);
        System.out.println(gr.checkPass() ? "Passing!" : "Failing");
    }
}