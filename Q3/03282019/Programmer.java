public class Programmer extends Profile {
    private String title;

    public Programmer(String employeeName, String employerName, String title) {
        super(employeeName, employerName);
        this.title = title;
    }

    public String getInfo() { return title + " Name: " + getEmployeeName() + ", Employer: " + getEmployerName(); }
}