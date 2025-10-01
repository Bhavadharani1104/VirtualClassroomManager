
public class ProxyATM implements ATM {
    private RealBankAccount realAccount;

    public ProxyATM(String account, double balance) {
        this.realAccount = new RealBankAccount(account, balance);
    }

    @Override
    public void withdraw(String account, double amount) {
        if (authenticate(account)) {
            realAccount.withdraw(account, amount);
        } else {
            System.out.println("Authentication failed. Access denied.");
        }
    }

    private boolean authenticate(String account) {
        return account.equals("12345"); // dummy PIN check
    }
}
