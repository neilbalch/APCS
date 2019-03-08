import java.awt.Point;

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
        System.out.println();
    }

    public void replaceLargest() {
        Point largest = new Point(0, 0);
        for(int r = 0; r < numMatrix.length; r++) {
            for(int c = 0; c < numMatrix[r].length; c++) {
                if(numMatrix[r][c] > numMatrix[largest.x][largest.y]) largest = new Point(r, c);
            }
        }

        numMatrix[largest.x][largest.y] = -1;
    }
}