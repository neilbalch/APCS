public class One {
    private int length;
    private int width;

    public One() {
        length = 0;
        width = 0;
    }

    public One(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public void printArea() {
        System.out.println("Area is: " + length * width);
    }

    public void printArea(int length, int width) {
        System.out.println("Area is: " + length * width);
    }
}