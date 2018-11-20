import java.util.Scanner;

public class ModExRunner {
    public static void main(String[] args) {
        ModEx ex = new ModEx();
        Scanner sc = new Scanner(System.in);

        System.out.print("Number? ");
        int num = sc.nextInt();

        ex.checkOddOrEven(num);

        ex.checkPrime(8);
        ex.checkPrime(17);
        ex.checkPrime(587);
    }
}
