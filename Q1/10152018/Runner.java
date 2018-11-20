public class Runner {
    public static void main(String[] args) {
        MiniBank mb = new MiniBank(100.0);

        mb.printBalance();
        mb.withdraw(10.50);
        mb.deposit(323.32);
    }
}