package payment_system;

public class Order {
    int orderId;
    Product product;
    boolean cancelled = false;

    public Order(int id, Product p) {
        orderId = id;
        product = p;
    }

    void cancel() {
        cancelled = true;
        System.out.println("Order cancelled");
    }
}