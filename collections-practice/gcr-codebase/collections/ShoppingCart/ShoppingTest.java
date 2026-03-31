import java.util.*;

public class ShoppingTest {
    public static void main(String[] args){
        ProductCatalog catalog = new ProductCatalog();
        catalog.addProduct("Apple", 50);
        catalog.addProduct("Milk", 60);
        catalog.addProduct("Bread", 40);
        catalog.addProduct("Rice", 90);

        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Milk", 2);
        cart.addItem("Apple", 5);
        cart.addItem("Bread", 1);
        cart.addItem("Rice", 1);

        System.out.println("Product Prices (HashMap)");
        System.out.println(catalog.getAllProducts());

        System.out.println("\nCart Items (LinkedHashMap - insertion order)");
        System.out.println(cart.getCartItems());

        System.out.println("\nCart Items Sorted By Price (TreeMap)");
        TreeMap<Integer, List<String>> sorted = cart.itemsSortedByPrice(catalog);
        for (Map.Entry<Integer, List<String>> e : sorted.entrySet()) {
            System.out.println("Price " + e.getKey() + " -> " + e.getValue());
        }

        System.out.println("\nTotal Amount = " + cart.getTotal(catalog));
    }
}
