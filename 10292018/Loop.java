public class Loop {
    private int min;
    private int max;

    public Loop(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public void countWhile() {
        int i = min;
        while(i <= max) {
            System.out.println(i);
            i += 2;
        }
    }

    public int getSum() {
        int total = 0;
        int i = min;
        do {
            total += i;
            i++;
        } while (i <= max);

        return total;
    }
}