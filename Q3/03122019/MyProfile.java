public class MyProfile extends Profile {
    private int age;

    public MyProfile(String name, int age) {
        super(name);
        this.age = age;
    }

    public String toString() {
        return super.toString() + " and my age is: " + age;
    }
}