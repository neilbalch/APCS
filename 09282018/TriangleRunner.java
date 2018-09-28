public class TriangleRunner {
    public static void main(String[] args) {
        Triangle t1 = new Triangle();
        t1.printArea();

        Triangle t2 = new Triangle(10, 12);
        t2.printArea();

        t2.update(3 , 5);
        t2.printArea();
    }
}