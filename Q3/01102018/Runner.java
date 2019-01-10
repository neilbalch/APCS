public class Runner {
    public static void main(String[] args) {
        Review rvw = new Review(5);
        rvw.printArray();
        System.out.println(rvw.getLargest());


        StringTest test1 = new StringTest("The quick brown fox jumps over the lazy dog");
        test1.printInfo();
        test1.printChar(0);
        test1.printChar(5);
        test1.printChar(10);
        test1.printChar(15);
        test1.printLocation("h");
        test1.printLocation("e");
        test1.printLocation("jumps");
        test1.printLocation("dog");
        test1.countChar('o');

        StringTest2 test2 = new StringTest2("hello java");
        test2.printEachChar();
        System.out.println(test2.contians("dog"));
        System.out.println(test2.contians("java"));
        System.out.println(test2.countChar('a'));
        System.out.println(test2.countChar('z'));
    }
}