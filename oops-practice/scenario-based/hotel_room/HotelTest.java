package hotel_room;

public class HotelTest {
    public static void main(String[] args) {
        PricingStrategy r = new DeluxeRoom(101);
        System.out.println("Bill: " + r.calculatePrice(2));
    }
}