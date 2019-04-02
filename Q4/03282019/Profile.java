public abstract class Profile {
    private String employerName;
    private String employeeName;

    public Profile(String employeeName, String employerName) {
        this.employeeName = employeeName;
        this.employerName = employerName;
    }

    public abstract String getInfo();

    public String getEmployeeName() { return employeeName; }
    public String getEmployerName() { return employerName; }
}