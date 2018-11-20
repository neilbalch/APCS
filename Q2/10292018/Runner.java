public class Runner {
    public static void main(String[] args) {
        Loop loop = new Loop(10, 20);
        loop.countWhile();
        System.out.println(loop.getSum());
    }
}