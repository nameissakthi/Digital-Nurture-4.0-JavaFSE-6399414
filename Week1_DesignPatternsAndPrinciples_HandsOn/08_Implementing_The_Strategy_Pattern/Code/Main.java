public class Main {
    public static void main(String[] args) {

        System.out.println();
        
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9876-5432", "sakthi");
        PaymentStrategy payPalPayment = new PayPalPayment("sakthi@gmail.com");

        
        PaymentContext paymentContext = new PaymentContext(creditCardPayment);
        paymentContext.executePayment(100);

        paymentContext = new PaymentContext(payPalPayment);
        paymentContext.executePayment(200);
    }
}
