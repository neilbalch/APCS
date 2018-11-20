public class MiniBank {
    private double balance;

    public MiniBank(double initial_balance) {
        balance = initial_balance;
    }

    public void printBalance() {
        System.out.println("Balance: " + balance);
    }

    public void withdraw(double amount) {
        if(balance - amount >= 0) {
            balance -= amount;
            printBalance();
        } else {
            System.out.println("err: balance too low");
        }
    }

    public void deposit(double amount) {
        balance += amount;
        printBalance();
    }
}