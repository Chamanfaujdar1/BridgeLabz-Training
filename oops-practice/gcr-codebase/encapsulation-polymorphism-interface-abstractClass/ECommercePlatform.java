import java.util.*;

abstract class Product{
    private int productId;
    private String name;
    protected double price;

    public Product(int productId, String name, double price){
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public abstract double calculateDiscount();

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

class Electronics extends Product implements Taxable {

    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return price * 0.10; // 10% discount
    }

    @Override
    public double calculateTax() {
        return price * 0.18; // 18% GST
    }

    @Override
    public String getTaxDetails() {
        return "GST 18% applied";
    }
}

class Clothing extends Product implements Taxable {

    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return price * 0.20; // 20% discount
    }

    @Override
    public double calculateTax() {
        return price * 0.12; // 12% GST
    }

    @Override
    public String getTaxDetails() {
        return "GST 12% applied";
    }
}

class Groceries extends Product {

    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return price * 0.05; // 5% discount
    }
}

public class ECommercePlatform {
    public static void calculateFinalPrice(List<Product> products) {

        for (Product product : products) {
            double tax = 0;
            if (product instanceof Taxable) {
                tax = ((Taxable) product).calculateTax();
            }

            double discount = product.calculateDiscount();
            double finalPrice = product.getPrice() + tax - discount;

            System.out.println("Product: " + product.getName());
            System.out.println("Base Price: ₹" + product.getPrice());
            System.out.println("Tax: ₹" + tax);
            System.out.println("Discount: ₹" + discount);
            System.out.println("Final Price: ₹" + finalPrice);
            System.out.println("-------------");
        }
    }

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();

        products.add(new Electronics(101, "Laptop", 60000));
        products.add(new Clothing(102, "Jacket", 4000));
        products.add(new Groceries(103, "Rice Bag", 1200));

        calculateFinalPrice(products);
    }
}
