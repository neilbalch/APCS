public class Cone {
    public static void main(String[] args) {
        double pi = 3.14;
        double radius = 3.0;
        double height = 6.0;

        double volume = height * pi * Math.pow(radius, 2) / 3.0;

        System.out.println("The volume of a cone with radius=" + radius + ", height=" + height + " and assuming pi=" + pi + " is: " + volume);
    }
}