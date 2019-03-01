public class Runner {
    public static void main(String[] args) {
        int[][] array = new int[4][5];

        for(int r = 0; r < array.length; r++) {
            for(int c = 0; c < array[r].length; c++) {
                array[r][c] = (int)(50 * Math.random() + 1);
            }
        }

        Warmup wu = new Warmup(array);
        wu.print();
        System.out.println(wu.findLargest());
    }
}