import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Career p1 = new Career("Joe", 12, "math", "hiking", "potato chips");
        Career p2 = new Career("Jeff", 12, "math", "hiking", "potato chips");
        Career p3 = new Career("Jennifer", 12, "math", "hiking", "potato chips");

        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("Which profile do you want to change? (p1, p2, p3) Type q to quit.");
            String choice = sc.next().toLowerCase();

            if(choice.equals("p1") || choice.equals("p2") || choice.equals("p3")) {
                System.out.println("Alright... " + choice + "...");
                if(choice.equals("p1")) {
                    p1.printInfo();
                }
                if(choice.equals("p2")) {
                    p2.printInfo();
                }
                if(choice.equals("p3")) {
                    p3.printInfo();
                }

                sc.nextLine();
                System.out.print("New name? ");
                String name = sc.nextLine();
                System.out.print("New age? ");
                int age = sc.nextInt();
                System.out.print("New Favorite Subject? Choices: math, history, science: ");
                String subject = sc.next();
                System.out.print("New Favorite Hobby? Choices: hiking, sleep: ");
                String hobby = sc.next();
                sc.nextLine();
                System.out.print("New Favorite Food? Choices: potato chips, steak: ");
                String food = sc.nextLine();

                System.out.println("Alright, setting that now!");
                if(choice.equals("p1")) {
                    p1.updateProfile(name, age, subject, hobby, food);
                    System.out.println("Profile 1 is now:");
                    p1.printInfo();
                }
                if(choice.equals("p2")) {
                    p2.updateProfile(name, age, subject, hobby, food);
                    System.out.println("Profile 2 is now:");
                    p2.printInfo();
                }
                if(choice.equals("p3")) {
                    p3.updateProfile(name, age, subject, hobby, food);
                    System.out.println("Profile 3 is now:");
                    p3.printInfo();
                }
            } else if (choice.equals("q")) {
                return;
            } else {
                System.out.println("Nope. That's not an option!");
            }

            System.out.println("\n\n");
        }
    }
}