
public class PayFastAdapter implements PaymentProcessor {
    private final PayFastGateway payFast;

    public PayFastAdapter(PayFastGateway payFast) {
        this.payFast = payFast;
    }

    @Override
    public void processPayment(double amount) {
        payFast.sendPayment((float) amount);
    }

    @Override
    public boolean verifyTransaction(String transactionId) {
        return payFast.checkPaymentStatus(transactionId);
    }
}
