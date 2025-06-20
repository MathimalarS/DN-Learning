
public interface PaymentProcessor {
    void processPayment(double amount);

    boolean verifyTransaction(String transactionId);
}
