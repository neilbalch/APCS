public class Car extends Vehicle {
    public Car(String manufacturer) { super(manufacturer); }

    public String myInfo() { return super.myInfo() + " and I am a car."; }
}