public class PaypalAdapter implements PaymentProcessor {
    PaypalGateway paypalGateway;

    public PaypalAdapter() {
        paypalGateway = new PaypalGateway();
    }

    @Override
    public void processPayment(double amount){
        System.out.println("Payment Processing");
        paypalGateway.pay(amount);
    }
}
