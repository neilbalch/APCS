public class Runner {
    public static void main(String[] args) {
        Animal animal = new Animal();

        animal.setVariables();
        animal.printInfo();

        Radius radius = new Radius();
        radius.printArea(10);
        radius.printCir(10);
        radius.printConeVolume(10, 5);
    }
}