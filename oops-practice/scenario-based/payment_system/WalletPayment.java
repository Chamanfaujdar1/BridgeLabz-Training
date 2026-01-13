package payment_system;

public class WalletPayment implements Payment {
    public void pay(double amt) throws PaymentFailedException {
        System.out.println("Paid by Wallet: " + amt);
    }
}