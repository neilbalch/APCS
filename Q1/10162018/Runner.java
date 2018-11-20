public class Runner {
    public static void main(String[] args) {
        Pythagorean pyth = new Pythagorean();
        double answer = pyth.findC(5, 12);
        System.out.println("Answer: " + answer);
    }
}