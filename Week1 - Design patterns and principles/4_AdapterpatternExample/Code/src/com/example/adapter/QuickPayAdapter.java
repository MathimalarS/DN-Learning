public class QuickPayAdapter implements PaymentProcessor {
    private final QuickPayGateway quickPay;

    public QuickPayAdapter(QuickPayGateway quickPay) {
        this.quickPay = quickPay;
    }

    @Override
    public void processPayment(double amount) {
        quickPay.makePayment(amount);
    }

    @Override
    public boolean verifyTransaction(String transactionId) {
        int code;
        try {
            code = Integer.parseInt(transactionId);
        } catch (NumberFormatException e) {
            System.out.println("Invalid transaction ID format for QuickPay");
            return false;
        }
        int status = quickPay.getTransactionStatus(code);
        return status == 1;
    }
}
