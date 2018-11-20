public class Animal {
    private String animalType = "";
    private int age = 0;

    public void setVariables(String type, int age) {
        animalType = type;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("This is an " + animalType + " with an age of " + age + ".");
    }
}
