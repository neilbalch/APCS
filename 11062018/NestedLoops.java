public class NestedLoops {
    public static void drawFilledBox() {
        drawFilledBox(10, 10);
    }

    public static void drawFilledBox(int width, int height) {
        for(int i = 1; i <= height; i++) {
            for(int j = 1; j <= width; j++)
                System.out.print("*");
            System.out.println();
        }
    }

    public static void drawMultiChart() {
        for(int i = 1; i <= 9; i++) {
            for(int j = 1; j <= 9; j++)
                System.out.print((i * j) + "\t");
            System.out.println();
        }
    }

    public static void drawTriangle() {
        for(int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++)
                System.out.print("*");
            System.out.println();
        }
    }
}
