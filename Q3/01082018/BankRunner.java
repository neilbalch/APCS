import Bank.*;

public class BankRunner {
    public static void main(String[] args) {
        AccountManager mgr = new AccountManager("John Smith", 1234, 99.99);
        mgr.printInfo();
    }
}
