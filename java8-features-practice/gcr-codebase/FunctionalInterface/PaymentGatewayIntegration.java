public class PaymentGatewayIntegration {

    interface PaymentProcessor {

        void pay(double amount);

        default void refund(double amount) {
            System.out.println("Refund of ₹" + amount + " processed (default)");
        }
    }

    static class UPIProcessor implements PaymentProcessor {

        public void pay(double amount) {
            System.out.println("Paid ₹" + amount + " using UPI");
        }
    }

    static class CreditCardProcessor implements PaymentProcessor {

        public void pay(double amount) {
            System.out.println("Paid ₹" + amount + " using Credit Card");
        }

        public void refund(double amount) {
            System.out.println("Refund of ₹" + amount + " processed to Credit Card");
        }
    }

    public static void main(String[] args) {

        PaymentProcessor upi = new UPIProcessor();
        PaymentProcessor card = new CreditCardProcessor();

        upi.pay(1000);
        upi.refund(200);

        card.pay(5000);
        card.refund(1000);
    }
}
