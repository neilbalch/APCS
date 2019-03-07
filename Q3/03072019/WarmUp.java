public class WarmUp {
    private int[][] numMatrix;

    public WarmUp(int[][] mat) { numMatrix = mat; }

    public void print() {
        for(int[] row : numMatrix) {
            for(int item : row) {
                System.out.print(item + "\t");
            }
            System.out.println();
        }
    }

    public int sumRow(int row) {
        if(row >= numMatrix.length) return -1;

        int sum = 0;
        for(int c = 0; c < numMatrix[row].length; c++) c += numMatrix[row][c];

        return sum;
    }
}