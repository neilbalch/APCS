public class ArrayTest {
    private int numbers[];

    public ArrayTest(int length) {
        numbers = new int[length];

        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = (int)(5 * Math.random() + 10);
        }
    }

    public void print() {
        for(int i : numbers) {
            System.out.println(i);
        }
    }

    public int sun13() {
        int sum = 0;
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] == 13)
                continue;
            else {
                sum += numbers[i];
            }
        }

        return sum;
    }
}