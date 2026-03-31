package inventory_management;

public class Inventory {
    InventoryProduct[] items = new InventoryProduct[5];
    int idx = 0;
    AlertService alert = new InventoryAlert();

    void addProduct(InventoryProduct p) {
        items[idx++] = p;
    }

    void updateStock(int id, int q) throws OutOfStockException {
        for (int i = 0; i < idx; i++) {
            if (items[i].id == id) {
                items[i].qty = q;
                if (q == 0)
                    throw new OutOfStockException("Product out of stock");
                if (q < 3)
                    alert.alert("Low stock for " + items[i].name);
                return;
            }
        }
    }
}