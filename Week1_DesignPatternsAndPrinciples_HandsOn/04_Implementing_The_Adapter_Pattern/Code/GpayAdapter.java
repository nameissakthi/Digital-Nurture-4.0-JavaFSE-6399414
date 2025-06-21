public class GpayAdapter implements PaymentProcessor {
    GpayGateway gpayGateway;

    public GpayAdapter() {
        gpayGateway = new GpayGateway();
    }

    @Override
    public void processPayment(double amount){
        System.out.println("Payment Processing");
        gpayGateway.pay(amount);
    }
}
