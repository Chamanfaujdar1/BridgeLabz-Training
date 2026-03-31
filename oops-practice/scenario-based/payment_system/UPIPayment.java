package payment_system;

public class UPIPayment implements Payment {
    public void pay(double amt) throws PaymentFailedException {
        System.out.println("Paid by UPI: " + amt);
    }
}