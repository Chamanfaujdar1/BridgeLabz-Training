package inventory_management;

public class InventoryTest {
    public static void main(String[] args) {
        Inventory inv = new Inventory();
        inv.addProduct(new InventoryProduct(1, "Mouse", 2));

        try {
            inv.updateStock(1, 2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}