package vehicle_rental;

public class Car extends Vehicle implements IRentable {
    public Car(String n) {
        super(n, 800);
    }

    public double calculateRent(int days) {
        return days * rate;
    }
}