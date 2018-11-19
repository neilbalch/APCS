public class ArrayTest {
    private int[] numbers;

    public ArrayTest(int size) {
        numbers = new int[size];
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = (int)(Math.random() * 5 + 1);
        }
    }

    public void print() {
        for(int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }

    public int getSum() {
        int sum = 0;

        for(int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        return sum;
    }
}