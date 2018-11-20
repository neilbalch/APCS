public class Runner {
    public static void main(String[] args) {
        System.out.println(Count.getFactorial(5));

        ForTest.printCount();
        ForTest.printCount(21);
        ForTest.printCount(5, 20);
        System.out.println(ForTest.getFactorial(5));
    }
}