public class Runner {
    public static void main(String[] args) {
        Car c = new Car("Ford");
        Motorcycle m = new Motorcycle("Harley-Davidson");
        Vehicle v = (Vehicle)m;

        System.out.println(c.myInfo());
        System.out.println(m.myInfo());
        System.out.println(v.myInfo());
    }
}