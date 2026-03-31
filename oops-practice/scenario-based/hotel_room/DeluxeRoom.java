package hotel_room;

public class DeluxeRoom extends Room implements PricingStrategy {
    public DeluxeRoom(int no) {
        super(no);
    }

    public double calculatePrice(int d) {
        return d * 3000;
    }
}