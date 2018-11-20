public class Table {
    private int row;
    private int col;

    public Table(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void printDrawBox() {
        for(int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}