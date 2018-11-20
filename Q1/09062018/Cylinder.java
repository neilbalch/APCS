public class Cylinder {
    public static void main(String[] args) {
        double pi = 3.14;
        double radius = 6.0;
        double height = 10.0;
        double volume = pi * Math.pow(radius, 2) * height;

        System.out.println("A cylinder with radius=" + radius + " height=" + height + " and assuming pi=" + pi + " has a vollume of=" + volume);
    }
}