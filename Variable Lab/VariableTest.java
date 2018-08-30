import java.util.Scanner;

public class VariableTest {
    public static void main(String[] args) {
        byte by = 123;
        short s = 12345;
        int i = 1234567;
        long l = 987654;
        float f = 123.123f;
        double d = 2134.1234;
        char c = 'A';
        boolean bl = true;

        System.out.println("by is a byte and has the value: " + by);
        System.out.println("s is a short and has the value: " + s);
        System.out.println("i is a int and has the value: " + i);
        System.out.println("l is a long and has the value: " + l);
        System.out.println("f is a float and has the value: " + f);
        System.out.println("d is a double and has the value: " + d);
        System.out.println("c is a char and has the value: " + c);
        System.out.println("bl is a boolean and has the value: " + bl);

        System.out.println("///////////////////PART 2//////////////////////");

        char[] hello = new char[] {34, 72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100, 34, /*Line Feed Char*/ 10};
        for(char ltr : hello) {
            System.out.print(ltr);
        }

        System.out.println("///////////////////PART 3//////////////////////");

        int length = 5;
        int width = 10;
        int area = width * length;
        System.out.println("Using the formula for the area of a rectangle, area = length * width, if the length is " + length + " and the height is " + width + " then the area is " + area);

        int depth = 20;
        int volume = width * length * depth;
        System.out.println("Using the formula for the volume of a cube, volume = length * width * depth, if the length is " + length + ", the width is " + width + " and the depth is " + depth + " then the volume is " + volume);

        int cir_radius = 5;
        int cir_area = (int)(Math.PI * Math.pow(cir_radius, 2));
        System.out.println("Using the formula for the area of a circle, area = pi * r^2, if r is " + cir_radius + " then the area is " + cir_area);

        int sph_radius = 5;
        int sph_volume = (int)(4 * Math.PI * Math.pow(sph_radius, 3) / 3);
        System.out.println("Using the formula for the volume of a sphere, volume = 4 * pi * r^3 / 3, and the radius is " + sph_radius + " then the volume is " + sph_volume);

        int cyl_radius = 5;
        int cyl_height = 10;
        int cyl_volume = (int)(cyl_height * Math.PI * Math.pow(cyl_radius, 2));
        System.out.println("USing the formula for the volume of a cylinder, volume = pi * r^2 * height, if r is " + cyl_radius + " and the height " + cyl_height + " then the volume is " + cyl_volume);

        System.out.println("///////////////////PART 4//////////////////////");

        double a = 3.0;
        double b = 4.0;
        double c_ = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        System.out.println("Using the pythagorean therom, a^2 + b^2 = c^2, if a is " + a + " and b is " + b + " then c is " + c_);

        double y2 = 10.0;
        double y1 = 5.0;
        double x2 = 5.0;
        double x1 = 0.0;
        double distance = Math.sqrt(Math.pow(y2 - y1, 2) + Math.pow(x2 - x1, 2));
        System.out.println("Using the distance formula, distance = sqrt((y2 - y1)^2 + (x2 - x1)^2), if y2 is " + y2 + ", y1 is " + y1 + ", x2 is " + x2 + ", and x1 is " + x1 + " then the distance is " + distance);

        double db_cir_radius = 12.0;
        double circumference = 2 * Math.PI * db_cir_radius;
        System.out.println("Using the formula for the circumference of a circle, cir = 2pi*r, if r is " + db_cir_radius + ", then the circumference is " + circumference);

        double m_y2 = 10.0;
        double m_y1 = 5.0;
        double m_x2 = 5.0;
        double m_x1 = 0.0;
        double m = (y2 - y1) / (x2 - x1);
        System.out.println("Using the slope formula, m = (y2 - y1) / (x2 - x1), if y2 is " + y2 + ", y1 is " + y1 + ", x2 is " + x2 + ", and x1 is " + x1 + " then the slope is " + m);

        double tr_base = 12.0;
        double tr_height = 6.0;
        double tr_area = 0.5 * tr_base * tr_height;
        System.out.println("Using the formula for the area of a triangle, area = 0.5 * base * height, if the base is " + tr_base + " and the height is " + tr_height + ", then the area is " + tr_area);

        System.out.println("///////////////////CHALLENGE//////////////////////");

        Scanner reader = new Scanner(System.in);
        System.out.println("\"Area of a circle\"");
        System.out.println("Please enter an integer radius. ");
        int scan_radius = reader.nextInt();

        double pi = 3.14;
        double scan_area = pi * Math.pow(scan_radius, 2);
        System.out.println("If the radius of the circle is " + scan_radius + " and we assume pi to be " + pi + " then the area is " + scan_area);


        System.out.println("\n\"Circumference of a circle\"");
        System.out.println("Please enter an integer radius. ");
        scan_radius = reader.nextInt();

        double scan_circumference = 2 * pi * scan_radius;
        System.out.println("If the radius of the circle is " + scan_radius + " and we assume pi to be " + pi + " then the circumderence is " + scan_circumference);

        reader.close();
    }
}