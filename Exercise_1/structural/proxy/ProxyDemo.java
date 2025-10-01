
public class ProxyDemo {
    public static void main(String[] args) {
        ATM atm = new ProxyATM("12345", 5000);

        atm.withdraw("12345", 1000);  // success
        atm.withdraw("54321", 500);   // fail
    }
}
