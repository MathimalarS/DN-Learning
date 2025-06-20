public class QuickPayGateway {
    public void makePayment(double amountInUSD) {
        System.out.println("QuickPay processing payment of $" + amountInUSD);
    }

    public int getTransactionStatus(int transactionCode) {
        System.out.println("QuickPay checking status for transaction code " + transactionCode);
        return 1; // 1 means success, 0 means pending, -1 means failed
    }
}
