package vehicle_rental;

public class Bike extends Vehicle implements IRentable {
    public Bike(String n) {
        super(n, 300);
    }

    public double calculateRent(int days) {
        return days * rate;
    }
}