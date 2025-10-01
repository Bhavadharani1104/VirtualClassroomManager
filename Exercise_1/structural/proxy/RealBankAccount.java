
public class RealBankAccount implements ATM {
    private String accountNumber;
    private double balance;

    public RealBankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    @Override
    public void withdraw(String account, double amount) {
        if (this.accountNumber.equals(account) && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal of ₹" + amount + " successful. Remaining balance: ₹" + balance);
        } else {
            System.out.println("Insufficient funds or invalid account.");
        }
    }
}
