public class DigitalPayment {
    interface Payment{
        void pay(double amount);
    }

    static class UPI implements Payment{
        public void pay(double amount){
            System.out.println("Amount paid using UPI: " + amount);
        }
    }

    static class CreditCard implements Payment{
        public void pay(double amount){
            System.out.println("Amount paid using Credit Card: " + amount);
        }
    }

    static class Wallet implements Payment{
        public void pay(double amount){
            System.out.println("Amount paid using Wallet: " + amount);
        }
    }

    public static void main(String[] args){
        Payment upi = new UPI();
        Payment creditCard = new CreditCard();
        Payment wallet = new Wallet();

        upi.pay(1500.75);
        creditCard.pay(2500.00);
        wallet.pay(500.25);
    }
}
