public class Runner {
    public static void main(String[] args) {
        ComputerScienceStudent cs = new ComputerScienceStudent("Barbara");
        System.out.println(cs.saying());
        System.out.println(((Student)cs).saying());
    }
}