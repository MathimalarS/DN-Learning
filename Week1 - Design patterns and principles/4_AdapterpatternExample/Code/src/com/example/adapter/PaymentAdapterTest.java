public class PaymentAdapterTest {
    public static void main(String[] args) {
        PayFastGateway payFastGateway = new PayFastGateway();
        PaymentProcessor payFastProcessor = new PayFastAdapter(payFastGateway);
        payFastProcessor.processPayment(150.75);
        System.out.println("PayFast transaction verified: " + payFastProcessor.verifyTransaction("TXN123"));

        System.out.println();

        QuickPayGateway quickPayGateway = new QuickPayGateway();
        PaymentProcessor quickPayProcessor = new QuickPayAdapter(quickPayGateway);
        quickPayProcessor.processPayment(200.00);
        System.out.println("QuickPay transaction verified: " + quickPayProcessor.verifyTransaction("456"));
    }
}
