import java.util.Scanner;

public class Warmup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter a verb: ");
        String verb = sc.next();

        //sc.next();
        System.out.print("Excellent now please enter a noun: ");
        String noun = sc.next();

        System.out.println("The cat " + verb + " the lazy dog across the " + noun);
    }
}