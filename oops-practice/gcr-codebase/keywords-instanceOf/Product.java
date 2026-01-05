public class Product {
    static double discount = 10.0;

    final String productID;
    String productName;
    double price;
    int quantity;

    Product(String productID, String productName, double price, int quantity){
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    static void applyDiscount(double newDiscount){
        discount = newDiscount;
    }

    void displayDetails(){
        double priceAfterDiscount = this.price - (this.price * discount /100);
        System.out.println("Product ID: " + productID);
        System.out.println("Product Name: " + productName);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Price after Discount: $" + priceAfterDiscount);
    }

    public static void main(String[] args){
        Product product1 = new Product("P001", "Laptop", 1200.0, 5);
        Product product2 = new Product("P002", "Smartphone", 800.0, 10);

        if(product1 instanceof Product){
            product1.displayDetails();
        }
        if(product2 instanceof Product){
            product2.displayDetails();
        }
    }
}
