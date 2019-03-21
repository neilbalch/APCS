public class Motorcycle extends Vehicle {
    public Motorcycle(String manufacturer) { super(manufacturer); }

    public String myInfo() { return super.myInfo() + " and I am a motorcycle."; }
}