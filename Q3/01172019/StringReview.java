public class StringReview {
    private String fullname;

    public StringReview(String fullname) {
        this.fullname = fullname;
    }

    public String getLastName() {
        return fullname.substring(fullname.lastIndexOf(".") + 1);
    }

    public String toString() {
       return "Your name is: " + fullname.substring(0, fullname.indexOf(".")) + " " +
               fullname.substring(fullname.indexOf(".") + 1, fullname.lastIndexOf(".")) + " " +
               fullname.substring(fullname.lastIndexOf(".") + 1);
    }
}