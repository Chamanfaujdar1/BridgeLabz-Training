import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem {
    private final String itemId;
    private final String name;

    public WarehouseItem(String itemId, String name) {
        this.itemId = itemId;
        this.name = name;
    }

    public String getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public abstract String getCategory();

    @Override
    public String toString() {
        return String.format("[%s] ID: %s | Name: %s", getCategory(), itemId, name);
    }
}

class Electronics extends WarehouseItem {
    private final String brand;
    private final int warrantyMonths;

    public Electronics(String itemId, String name, String brand, int warrantyMonths) {
        super(itemId, name);
        this.brand = brand;
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public String getCategory() {
        return "Electronics";
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format(" | Brand: %s | Warranty: %d months", brand, warrantyMonths);
    }
}

class Groceries extends WarehouseItem {
    private final String expiryDate;
    private final double weightKg;

    public Groceries(String itemId, String name, String expiryDate, double weightKg) {
        super(itemId, name);
        this.expiryDate = expiryDate;
        this.weightKg = weightKg;
    }

    @Override
    public String getCategory() {
        return "Groceries";
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format(" | Expiry: %s | Weight: %.2f kg", expiryDate, weightKg);
    }
}

class Furniture extends WarehouseItem {
    private final String material;
    private final String size;

    public Furniture(String itemId, String name, String material, String size) {
        super(itemId, name);
        this.material = material;
        this.size = size;
    }

    @Override
    public String getCategory() {
        return "Furniture";
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format(" | Material: %s | Size: %s", material, size);
    }
}

class Storage<T extends WarehouseItem> {
    private final List<T> items;

    public Storage() {
        this.items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
        System.out.println(" Added: " + item.getName());
    }

    public T getItem(int index) {
        if (index < 0 || index >= items.size()) {
            throw new IndexOutOfBoundsException(" Invalid index: " + index);
        }
        return items.get(index);
    }

    public List<T> getAllItems() {
        return items;
    }

    public int size() {
        return items.size();
    }
}

public class SmartWarehouseSystem {

    public static void displayAllItems(List<? extends WarehouseItem> itemList) {
        System.out.println("\n Warehouse Items Display:");
        if (itemList == null || itemList.isEmpty()) {
            System.out.println(" No items found in storage.");
            return;
        }

        for (WarehouseItem item : itemList) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {

        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("E101", "Laptop", "Dell", 12));
        electronicsStorage.addItem(new Electronics("E102", "Smartphone", "Samsung", 24));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("G201", "Rice", "2026-12-10", 5.0));
        groceriesStorage.addItem(new Groceries("G202", "Milk", "2026-01-30", 1.0));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("F301", "Chair", "Wood", "Medium"));
        furnitureStorage.addItem(new Furniture("F302", "Table", "Steel", "Large"));

        displayAllItems(electronicsStorage.getAllItems());
        displayAllItems(groceriesStorage.getAllItems());
        displayAllItems(furnitureStorage.getAllItems());

        System.out.println("\n Retrieved Item:");
        Electronics item = electronicsStorage.getItem(0);
        System.out.println(item);
    }
}
