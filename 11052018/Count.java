public class Count {
    public static int getFactorial(int num) {
        int total = num;

        for(int i = num - 1; i > 0; i--) {
            total *= i;
        }

        return total;
    }
}