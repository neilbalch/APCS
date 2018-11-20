public class Rectangle {
    private int length;
    private int width;

    Rectangle() {
        length = 0;
        width = 0;
    }

    Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public void printArea() {
        System.out.println("The area of the specified rectangle is: " + (length * width));
    }
}
