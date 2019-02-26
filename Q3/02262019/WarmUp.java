public class WarmUp {
    private int[][] numMatrix;

    public WarmUp() {
        numMatrix = new int[4][5];
        for(int r = 0; r < numMatrix.length; r++) {
            for(int c = 0; c < numMatrix[r].length; c++) {
                numMatrix[r][c] = (int)(5 * Math.random() + 1);
            }
        }
    }

    public void print() {
        for(int[] row : numMatrix) {
            for(int item : row) {
                System.out.print(item + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void find(int query) {
        for(int r = 0; r < numMatrix.length; r++) {
            for (int c = 0; c < numMatrix[r].length; c++) {
                if(numMatrix[r][c] == query) numMatrix[r][c] = 99;
            }
        }
    }
}