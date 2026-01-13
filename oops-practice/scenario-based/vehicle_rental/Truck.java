package vehicle_rental;

public class Truck extends Vehicle implements IRentable {
    public Truck(String n) {
        super(n, 1500);
    }

    public double calculateRent(int days) {
        return days * rate;
    }
}