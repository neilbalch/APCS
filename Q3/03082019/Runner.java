public class Runner {
    public static void main(String[] args) {
        int[][] mat = new int[4][5];
        for(int r = 0; r < mat.length; r++) {
            for(int c = 0; c < mat[r].length; c++) {
                mat[r][c] = (int)(50 * Math.random() + 1);
            }
        }

        WarmUp wu = new WarmUp(mat);
        wu.print();
        wu.replaceLargest();
        wu.print();
    }
}