package payment_system;

public interface Payment {
    void pay(double amt) throws PaymentFailedException;
}