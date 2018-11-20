public class Runner {
    public static void main(String[] args) {
        //(1) Where is Chicken coming from?
        // Chicken class in Chicken.java
        Chicken chicken = new Chicken();

        //(2) What is the significance of the variable chicken?
        //(3) Where is speak() coming from and what does it do?
        // speak() is from the Chicken class
        chicken.speak();
        chicken.speak();
        chicken.speak();

        Dog dog = new Dog();

        dog.speak();
        dog.speak();
        dog.speak();
        dog.speak();
    }
}