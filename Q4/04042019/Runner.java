public class Runner {
    public static void main(String[] args) {
        Programmer p1 = new Programmer("Jennifer");
        Teacher t1 = new Teacher("John");

        p1.getInfo();
        Programmer.addCredits(10);
        t1.getInfo();
        Teacher.addCredits(12);
        System.out.println("Credits: " + Programmer.getCredits());
    }
}