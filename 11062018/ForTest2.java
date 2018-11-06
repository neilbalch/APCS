public class ForTest2 {
    public static void printCount(int min, int max) {
        for(int i = min; i <= max; i++) {
            System.out.println(i);
        }
    }

    public static int getSum(int max) {
        int sum = 0;
        for(int i = 1; i <= max; i++) {
            sum += i;
        }

        return sum;
    }
}