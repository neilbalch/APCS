import java.util.Scanner;

public class Trivia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("WELCOME TO THE APCS TRIVIA GAME!");
        System.out.println("Ready to play?");

        System.out.println("Alllllllright! First up: what class is this?");
        System.out.print("> ");
        String apcs = sc.next();
        if(apcs.toLowerCase().equals("apcs")) {
            System.out.println("Ay! You got it right!");
        } else {
            System.out.println("Agh! The correct answer was APCS. Wah Wah Wah.");
        }

        // Clear whitespace buffer
        sc.nextLine();

        System.out.println("Aiiiiiiight! Last Question: What is the name of the space station up in orbit?");
        System.out.print("> ");
        String iss = sc.nextLine();

        if(iss.toLowerCase().equals("iss") || iss.toLowerCase().equals("international space station")) {
            System.out.println("Ay! You got it right!");
        } else {
            System.out.println("Agh! The correct answer was ISS (International Space Station). Wah Wah Wah.");
        }
    }
}
