import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Game2 g2 = new Game2();

        while(true) {
            System.out.print("Guess a number from 1 to 99: ");
            int guess = sc.nextInt();

            if(guess == g2.getNumber()) {
                System.out.println("YAY! You guessed it!");
                break;
            } else if(guess > g2.getNumber()) {
                System.out.println("Nope, you guessed too high.");
            } else if(guess < g2.getNumber()) {
                System.out.println("Nope, you guessed too low.");
            }
        }
    }
}