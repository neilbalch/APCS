public class Contact {
    private String firstName;
    private String lastName;
    private String email;

    public Contact(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmailUsername() { return email.substring(0, email.indexOf("@")); }
    public String getEmailDomain() { return email.substring(email.indexOf("@") + 1, email.indexOf(".")); }
    public String getEmailTLD() { return email.substring(email.lastIndexOf(".") + 1); }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmail(String email) { this.email = email; }

    public String toString() {
        return "Name: " + firstName + " " + lastName + " Email: " + email;
    }
}
