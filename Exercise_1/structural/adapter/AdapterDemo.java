
public class AdapterDemo {
    public static void main(String[] args) {
        UPIPayment gpay = new PaymentAdapter(new GooglePay());
        gpay.pay("500");

        UPIPayment paytm = new PaymentAdapter(new Paytm());
        paytm.pay("1000");
    }
}
