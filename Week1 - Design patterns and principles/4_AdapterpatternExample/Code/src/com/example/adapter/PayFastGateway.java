
public class PayFastGateway {
    public void sendPayment(float amount) {
        System.out.println("PayFast processing payment of $" + amount);
    }

    public boolean checkPaymentStatus(String txnId) {
        System.out.println("PayFast checking status for transaction " + txnId);
        return true;
    }
}
