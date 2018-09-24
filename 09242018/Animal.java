public class Animal {
    private String animalType = "";
    private int age = 0;

    public void setVariables() {
        animalType = "dog";
        age = 5;
    }

    public void printInfo() {
        System.out.println("This animal is an " + animalType + ".");
        System.out.println("It is " + age + " years old.");
    }
}