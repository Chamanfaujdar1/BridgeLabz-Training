import java.util.*;

class Customer {
    String name;
    LinkedHashMap<String, Integer> items;

    Customer(String name) {
        this.name = name;
        this.items = new LinkedHashMap<>();
    }

    void addItem(String itemName, int qty) {
        items.put(itemName, items.getOrDefault(itemName, 0) + qty);
    }
}

public class SmartCheckout{
    public static void main(String[] args){
        HashMap<String, Integer> priceMap = new HashMap<>();
        priceMap.put("Milk", 60);
        priceMap.put("Bread", 40);
        priceMap.put("Apple", 10);
        priceMap.put("Rice", 90);

        HashMap<String, Integer> stockMap = new HashMap<>();
        stockMap.put("Milk", 5);
        stockMap.put("Bread", 3);
        stockMap.put("Apple", 20);
        stockMap.put("Rice", 4);

        Queue<Customer> queue = new LinkedList<>();

        Customer c1 = new Customer("Aman");
        c1.addItem("Milk", 2);
        c1.addItem("Apple", 5);

        Customer c2 = new Customer("Neha");
        c2.addItem("Bread", 2);
        c2.addItem("Rice", 1);

        Customer c3 = new Customer("Ravi");
        c3.addItem("Milk", 4);

        queue.add(c1);
        queue.add(c2);
        queue.add(c3);

        while(!queue.isEmpty()){
            Customer customer = queue.remove();
            int total = 0;

            System.out.println("\nCustomer: " + customer.name);

            for(Map.Entry<String, Integer> e : customer.items.entrySet()){
                String item = e.getKey();
                int qty = e.getValue();

                if (!priceMap.containsKey(item)) {
                    System.out.println(item + " not available in price list");
                    continue;
                }

                if (!stockMap.containsKey(item)) {
                    System.out.println(item + " out of stock");
                    continue;
                }

                int stock = stockMap.get(item);

                if (stock < qty) {
                    System.out.println(item + " insufficient stock | Needed: " + qty + " Available: " + stock);
                    continue;
                }

                int price = priceMap.get(item);
                int cost = price * qty;

                stockMap.put(item, stock - qty);
                total += cost;

                System.out.println(item + " x " + qty + " = " + cost);
            }

            System.out.println("Total Bill: " + total);
        }

        System.out.println("\nUpdated Stock:");
        System.out.println(stockMap);
    }
}