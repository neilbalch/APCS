public class ArrayTest {
    private int[] numbers;

    public ArrayTest(int size) {
        numbers = new int[size];
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = (int)(Math.random() * 5 + 1);
        }
    }

    public void print() {
        for(int i : numbers) {
            System.out.println(i);
        }
    }

    public int getProduct() {
        int total = 1;

        for(int i : numbers) {
            total *= i;
        }

        return total;
    }
}