public class Warmup {
    private int[][] numMatrix;

    public Warmup(int[][] array) { numMatrix = array; }

    public void print() {
        for(int[] list : numMatrix) {
            for(int item : list) {
                System.out.print(item + "\t");
            }
            System.out.println();
        }
    }

    public int findLargest() {
        int largest = 0;
        for(int[] list : numMatrix) {
            for (int item : list) {
                if (item > largest) largest = item;
            }
        }

        return largest;
    }
}