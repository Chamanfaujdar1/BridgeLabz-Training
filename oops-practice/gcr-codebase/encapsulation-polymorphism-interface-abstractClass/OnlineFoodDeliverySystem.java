import java.util.*;

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void getItemDetails() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Price    : ₹" + price);
        System.out.println("Quantity : " + quantity);
    }

    public abstract double calculateTotalPrice();
}

interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {

    public VegItem(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    public double applyDiscount() {
        return calculateTotalPrice() * 0.08; // 8% discount
    }

    public String getDiscountDetails() {
        return "8% discount on Veg items";
    }
}

class NonVegItem extends FoodItem implements Discountable {

    private static final double NON_VEG_CHARGE = 50;

    public NonVegItem(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + NON_VEG_CHARGE;
    }

    public double applyDiscount() {
        return calculateTotalPrice() * 0.04; // 4% discount
    }

    public String getDiscountDetails() {
        return "4% discount + ₹50 non-veg charge";
    }
}

public class OnlineFoodDeliverySystem {

    public static void processOrder(List<FoodItem> orderItems) {
        double grandTotal = 0;

        for (FoodItem item : orderItems) {
            System.out.println("\n--- Order Item ---");
            item.getItemDetails();

            double total = item.calculateTotalPrice();
            double discount = 0;

            if (item instanceof Discountable) {
                Discountable d = (Discountable) item;
                discount = d.applyDiscount();
                System.out.println("Discount  : " + discount);
                System.out.println("Offer     : " + d.getDiscountDetails());
            }

            double finalAmount = total - discount;
            System.out.println("Final Bill: " + finalAmount);

            grandTotal += finalAmount;
        }

        System.out.println("\nGrand Total Payable: " + grandTotal);
    }

    public static void main(String[] args) {

        List<FoodItem> order = new ArrayList<>();

        order.add(new VegItem("Paneer Butter Masala", 250, 2));
        order.add(new NonVegItem("Chicken Biryani", 320, 1));

        processOrder(order);
    }
}
