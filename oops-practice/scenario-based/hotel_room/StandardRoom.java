package hotel_room;

public class StandardRoom extends Room implements PricingStrategy {
    public StandardRoom(int no) {
        super(no);
    }

    public double calculatePrice(int d) {
        return d * 1500;
    }
}