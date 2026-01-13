package inventory_management;

public class OutOfStockException extends Exception {
    public OutOfStockException(String msg) {
        super(msg);
    }
}