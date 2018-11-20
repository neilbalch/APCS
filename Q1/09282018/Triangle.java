public class Triangle {
    private int base, height;

    public Triangle() {
        base = 0;
        height = 0;
    }

    public Triangle(int base, int height) {
        update(base, height);
    }

    public void update(int base, int height) {
        this.base = base;
        this.height = height;
    }

    public void printArea() {
        System.out.println("The area of this triangle is: " + (0.5 * base * height));
    }
}