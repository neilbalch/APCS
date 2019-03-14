public class ComputerScienceStudent extends Student {
    public ComputerScienceStudent(String name) { super(name); }

    public String saying() { return super.saying() + " and I am studying programming"; }
}