public abstract class Profile {
    private String name;
    private static int count = 0;

    public Profile(String name) { this.name = name; }

    public abstract String getJobFunction();

    public String getName() { return "My name is: " + name; }

    public static void addCredits(int value) { count += value; }
    public static int getCredits() { return count; }
    public void getInfo() {
        System.out.println(getName());
        System.out.println(getJobFunction());
    }
}