public class Dog extends Animal {
    public Dog(String name) { super(name); }

    public void printInfo() {
        System.out.println(super.getName());
        speak();
    }

    @Override
    public void speak() {
        System.out.println("Woof");
    }
}