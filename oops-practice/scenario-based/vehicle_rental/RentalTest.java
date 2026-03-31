package vehicle_rental;

public class RentalTest {
    public static void main(String[] args) {
        Customer c = new Customer("Amit");

        IRentable v1 = new Bike("B101");
        IRentable v2 = new Car("C202");

        System.out.println("Bike Rent: " + v1.calculateRent(3));
        System.out.println("Car Rent: " + v2.calculateRent(2));
    }
}