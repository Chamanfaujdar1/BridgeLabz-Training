import java.util.*;

public class ProductCatalog {
    private final HashMap<String, Integer> priceMap = new HashMap<>();

    public void addProduct(String name, int price) {
        priceMap.put(name, price);
    }

    public boolean hasProduct(String name) {
        return priceMap.containsKey(name);
    }

    public int getPrice(String name) {
        return priceMap.get(name);
    }

    public Map<String, Integer> getAllProducts() {
        return new HashMap<>(priceMap);
    }
}
