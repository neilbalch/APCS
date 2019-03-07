public class Runner {
    public static void main(String[] args) {
        int[][] mat = new int[6][4];
        for(int r = 0; r < mat.length; r++) {
            for(int c = 0; c < mat[r].length; c++) {
                mat[r][c] = (int)(10 * Math.random() + 1);
            }
        }

        WarmUp wu = new WarmUp(mat);
        wu.print();
        System.out.println(wu.sumRow(2));
    }
}