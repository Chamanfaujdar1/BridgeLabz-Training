import java.util.Date;

// Base Class: The starting point of an order
class Order {
    String orderId;
    Date orderDate;

    Order(String orderId) {
        this.orderId = orderId;
        this.orderDate = new Date(); // Sets current date/time
    }

    String getOrderStatus() {
        return "Order Placed: " + orderId + " on " + orderDate;
    }
}

// Subclass (Level 2): Inherits Order
class ShippedOrder extends Order {
    String trackingNumber;

    ShippedOrder(String orderId, String trackingNumber) {
        super(orderId); // Passes orderId to Order constructor
        this.trackingNumber = trackingNumber;
    }

    @Override
    String getOrderStatus() {
        return super.getOrderStatus() + "\nStatus: Shipped [Tracking: " + trackingNumber + "]";
    }
}

// Subclass (Level 3): Inherits ShippedOrder (and indirectly Order)
class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    DeliveredOrder(String orderId, String trackingNumber, String deliveryDate) {
        super(orderId, trackingNumber); // Passes data up the chain
        this.deliveryDate = deliveryDate;
    }

    @Override
    String getOrderStatus() {
        return super.getOrderStatus() + "\nStatus: Delivered on " + deliveryDate;
    }
}

public class RetailSystem {
    public static void main(String[] args) {
        DeliveredOrder myOrder = new DeliveredOrder("ORD-9921", "TRK007892", "2026-01-03");
        System.out.println("--- Full Order History ---");
        System.out.println(myOrder.getOrderStatus());
    }
}
