import java.util.Scanner;

public class AnimalRunner {
    public static void main(String[] args) {
        Animal animal = new Animal();

        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter an animal species: ");
        String type = sc.next();
        System.out.print("Please enter the animal's age: ");
        int age = sc.nextInt();

        animal.setVariables(type, age);
        animal.printInfo();
    }
}
