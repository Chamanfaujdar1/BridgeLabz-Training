package inventory_management;

public class InventoryProduct {
    int id, qty;
    String name;

    public InventoryProduct(int id, String name, int qty) {
        this.id = id;
        this.name = name;
        this.qty = qty;
    }
}