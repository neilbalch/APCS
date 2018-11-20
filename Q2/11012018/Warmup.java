public class Warmup {
    private int num;

    public Warmup(int num) {
        this.num = num;
    }

    public void count() {
        for(int i = 1; i < num; i++) {
            System.out.println(i);
        }
    }

    public int factorial() {
        int total = 0;

        for(int i = num; i <= 1; i--) {
            total *= i;
        }

        return total;
    }
}