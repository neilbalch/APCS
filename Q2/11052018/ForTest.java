public class ForTest {
    public static void printCount() {
        printCount(100);
    }

    public static void printCount(int num) {
        printCount(0, 100);
    }

    public static void printCount(int min, int max) {
        for(int i = min; i <= max; i++) {
            System.out.println(i);
        }
    }

    public static int getFactorial(int num) {
        int total = num;

        for(int i = num - 1; i > 0; i--) {
            total *= i;
        }

        return total;
    }
}
