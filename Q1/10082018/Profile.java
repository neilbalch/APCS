public class Profile {
    private String name;
    private int age;

    public Profile(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("Name: " + name + ", age: " + age);
    }
}