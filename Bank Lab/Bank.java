public class Bank {
    private String name;

    private double balance;
    private final int pin;
    private boolean access;

    public Bank(String name, double balance_initial, int pin) {
        this.name = name;
        this.balance = balance_initial;
        this.pin = pin;

        // Start the bank account locked
        this.access = false;
    }

    // Unlock the account, checking the typed PIN. Returns new access status.
    public boolean unlock(int pin_entered) {
        // If already unlocked, don't try again
        if(access) {
            return true;
        }

        // Check PIN against stored PIN
        if(pin_entered == this.pin) {
            this.access = true;
            return true;
        } else {
            this.access = false;
            return false;
        }

    }

    // Lock the account
    public void lock() {
        this.access = false;
    }

    public String getName() {
        if(access) {
            return this.name;
        } else return "";
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        if(access) {
            return this.balance;
        } else return 0.0;
    }

    // Returns true if operation was successful, false if insufficient balance for operation
    public boolean withdraw(double amount) {
        if(access) {
            if (this.balance - amount < 0) {
                return false;
            } else {
                this.balance -= amount;
                return true;
            }
        } else return false;
    }

    public void deposit(double amount) {
        if(access) {
            this.balance += amount;
        } else return;
    }
}