public class Student extends Profile {
    public Student(String name) { super(name); }

    public String saying() { return super.saying() + " and I am a student"; }
}