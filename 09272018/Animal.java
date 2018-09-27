public class Animal {
    private String animalType = "";
    private int age = 0;

    public Animal() {
        animalType = "BLANK";
        age = 0;
    }

    public Animal(String animalType, int age) {
        this.animalType = animalType;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("Animal species is: " + animalType);
        System.out.println("Animal age is: " + age);
    }
}