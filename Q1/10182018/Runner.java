public class Runner {
    public static void main(String[] args) {
        Pythagorean pyth = new Pythagorean();

        pyth.findB(12, 13);
        System.out.println("Answer: " + pyth.getAnswer());
    }
}