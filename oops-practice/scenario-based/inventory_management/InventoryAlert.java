package inventory_management;

public class InventoryAlert implements AlertService {
    public void alert(String msg) {
        System.out.println("ALERT: " + msg);
    }
}