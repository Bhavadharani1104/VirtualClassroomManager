
public class PaymentAdapter implements UPIPayment {
    private Object paymentApp;

    public PaymentAdapter(Object app) {
        this.paymentApp = app;
    }

    @Override
    public void pay(String amount) {
        if (paymentApp instanceof GooglePay) {
            ((GooglePay) paymentApp).makePayment(Double.parseDouble(amount));
        } else if (paymentApp instanceof Paytm) {
            ((Paytm) paymentApp).doTransaction(amount);
        }
    }
}
