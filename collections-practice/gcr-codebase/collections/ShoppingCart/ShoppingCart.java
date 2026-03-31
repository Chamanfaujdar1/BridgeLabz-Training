import java.util.*;

public class ShoppingCart {
    private final LinkedHashMap<String, Integer> cart = new LinkedHashMap<>();

    public void addItem(String name, int qty) {
        cart.put(name, cart.getOrDefault(name, 0) + qty);
    }

    public void removeItem(String name) {
        cart.remove(name);
    }

    public LinkedHashMap<String, Integer> getCartItems() {
        return new LinkedHashMap<>(cart);
    }

    public int getTotal(ProductCatalog catalog) {
        int total = 0;
        for (Map.Entry<String, Integer> e : cart.entrySet()) {
            String item = e.getKey();
            int qty = e.getValue();
            total += catalog.getPrice(item) * qty;
        }
        return total;
    }

    public TreeMap<Integer, List<String>> itemsSortedByPrice(ProductCatalog catalog) {
        TreeMap<Integer, List<String>> map = new TreeMap<>();

        for (String item : cart.keySet()) {
            int price = catalog.getPrice(item);
            map.putIfAbsent(price, new ArrayList<>());
            map.get(price).add(item);
        }

        return map;
    }
}
