package Bank;

public class AccountManager {
    private Account account;

    public AccountManager(String name, int pin, double initial_balance) {
        account = new Account(name, pin, initial_balance);
    }

    public void printInfo() {
        System.out.println(account.toString());
    }
}
