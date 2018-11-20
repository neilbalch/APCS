import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.printInfo();

        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter an animal species: ");
        String species = sc.next();
        System.out.print("Please enter an animal age: ");
        int age = sc.nextInt();

        Animal animal2 = new Animal(species, age);
        animal2.printInfo();
    }
}