package Bank;

public class Account {
    private int pin;
    protected double balance;
    protected String name;

    public Account(String name, int pin, double initial_balance) {
        this.pin = pin;
        this.balance = initial_balance;
        this.name = name;
    }

    public String toString() {
        return "Name: " + name + ", Balance: " + balance;
    }
}
