public class MVHS implements School {
    private String name;
    private String address;

    public MVHS(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() { return name; }
    public String getAddress() { return address; }
}