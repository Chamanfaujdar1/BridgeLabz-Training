import java.util.ArrayList;
import java.util.List;

interface Category {
    String getCategoryName();
    double getMinPrice();
    double getMaxPrice();
}

class BookCategory implements Category {
    @Override
    public String getCategoryName() {
        return "Books";
    }

    @Override
    public double getMinPrice() {
        return 50;
    }

    @Override
    public double getMaxPrice() {
        return 2000;
    }
}

class ClothingCategory implements Category {
    @Override
    public String getCategoryName() {
        return "Clothing";
    }

    @Override
    public double getMinPrice() {
        return 200;
    }

    @Override
    public double getMaxPrice() {
        return 5000;
    }
}

class GadgetCategory implements Category {
    @Override
    public String getCategoryName() {
        return "Gadgets";
    }

    @Override
    public double getMinPrice() {
        return 500;
    }

    @Override
    public double getMaxPrice() {
        return 100000;
    }
}

class Product<T extends Category> {
    private final String productId;
    private final String name;
    private double price;
    private final T category;

    public Product(String productId, String name, double price, T category) {
        this.productId = productId;
        this.name = name;
        this.category = category;

        if (price < category.getMinPrice() || price > category.getMaxPrice()) {
            throw new IllegalArgumentException(
                    " Invalid price for " + category.getCategoryName() +
                            " category. Allowed range: " +
                            category.getMinPrice() + " - " + category.getMaxPrice()
            );
        }
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public T getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < category.getMinPrice() || price > category.getMaxPrice()) {
            throw new IllegalArgumentException(
                    " New price out of range for " + category.getCategoryName()
            );
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Category: %s | Price: ₹%.2f",
                productId, name, category.getCategoryName(), price);
    }
}

class ProductCatalog {
    private final List<Product<? extends Category>> products = new ArrayList<>();

    public void addProduct(Product<? extends Category> product) {
        products.add(product);
        System.out.println(" Added to catalog: " + product.getName());
    }

    public void displayCatalog() {
        System.out.println("\n Marketplace Product Catalog:");
        if (products.isEmpty()) {
            System.out.println(" Catalog is empty.");
            return;
        }

        for (Product<? extends Category> p : products) {
            System.out.println(p);
        }
    }
}

class DiscountUtil {

    public static <P extends Product<?>> void applyDiscount(P product, double percentage) {

        if (percentage <= 0 || percentage > 90) {
            System.out.println(" Invalid discount. Must be between 1% and 90%");
            return;
        }

        double oldPrice = product.getPrice();
        double newPrice = oldPrice - (oldPrice * percentage / 100);

        try {
            product.setPrice(newPrice);
            System.out.println(" Discount Applied: " + percentage + "% on " + product.getName());
            System.out.println("   Old Price: ₹" + oldPrice + " | New Price: ₹" + product.getPrice());
        } catch (IllegalArgumentException e) {
            System.out.println(" Discount failed: " + e.getMessage());
        }
    }
}

public class DynamicOnlineMarketplace {
    public static void main(String[] args) {

        BookCategory bookCategory = new BookCategory();
        ClothingCategory clothingCategory = new ClothingCategory();
        GadgetCategory gadgetCategory = new GadgetCategory();

        Product<BookCategory> book1 = new Product<>("B101", "Java Programming Book", 499, bookCategory);
        Product<ClothingCategory> cloth1 = new Product<>("C201", "Nike T-Shirt", 999, clothingCategory);
        Product<GadgetCategory> gadget1 = new Product<>("G301", "Samsung Phone", 25000, gadgetCategory);

        ProductCatalog catalog = new ProductCatalog();
        catalog.addProduct(book1);
        catalog.addProduct(cloth1);
        catalog.addProduct(gadget1);

        catalog.displayCatalog();

        System.out.println("\n Applying Discounts:");
        DiscountUtil.applyDiscount(book1, 10);
        DiscountUtil.applyDiscount(cloth1, 20);
        DiscountUtil.applyDiscount(gadget1, 15);

        catalog.displayCatalog();
    }
}
