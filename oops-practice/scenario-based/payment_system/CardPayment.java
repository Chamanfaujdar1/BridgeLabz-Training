package payment_system;

public class CardPayment implements Payment {
    public void pay(double amt) throws PaymentFailedException {
        if (amt <= 0)
            throw new PaymentFailedException("Payment Failed");
        System.out.println("Paid by Card: " + amt);
    }
}