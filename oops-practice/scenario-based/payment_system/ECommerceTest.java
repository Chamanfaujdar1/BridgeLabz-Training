package payment_system;

public class ECommerceTest {
    public static void main(String[] args) {
        Product p = new Product(1, "Laptop", 60000);
        Order o = new Order(101, p);

        Payment pay = new CardPayment();
        try {
            pay.pay(p.price);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        o.cancel();
    }
}