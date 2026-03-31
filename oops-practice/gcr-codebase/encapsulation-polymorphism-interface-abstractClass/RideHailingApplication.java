import java.util.*;

abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    private String currentLocation = "Unknown";

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    protected double getRatePerKm() {
        return ratePerKm;
    }

    protected String getLocation() {
        return currentLocation;
    }

    protected void setLocation(String location) {
        this.currentLocation = location;
    }

    public abstract double calculateFare(double distance);

    public void getVehicleDetails() {
        System.out.println("Vehicle ID      : " + vehicleId);
        System.out.println("Driver Name     : " + driverName);
        System.out.println("Rate Per KM     : ₹" + ratePerKm);
        System.out.println("Current Location: " + currentLocation);
    }
}

interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

class Car extends Vehicle implements GPS {

    public Car(String id, String driver, double ratePerKm) {
        super(id, driver, ratePerKm);
    }

    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    public String getCurrentLocation() {
        return getLocation();
    }

    public void updateLocation(String newLocation) {
        setLocation(newLocation);
    }
}

class Bike extends Vehicle implements GPS {

    public Bike(String id, String driver, double ratePerKm) {
        super(id, driver, ratePerKm);
    }

    public double calculateFare(double distance) {
        return (distance * getRatePerKm()) * 0.8;
    }

    public String getCurrentLocation() {
        return getLocation();
    }

    public void updateLocation(String newLocation) {
        setLocation(newLocation);
    }
}

class Auto extends Vehicle implements GPS {

    private static final double BASE_CHARGE = 20;

    public Auto(String id, String driver, double ratePerKm) {
        super(id, driver, ratePerKm);
    }

    public double calculateFare(double distance) {
        return BASE_CHARGE + (distance * getRatePerKm());
    }

    public String getCurrentLocation() {
        return getLocation();
    }

    public void updateLocation(String newLocation) {
        setLocation(newLocation);
    }
}

public class RideHailingApplication {

    public static void calculateRideFare(List<Vehicle> vehicles, double distance) {

        for (Vehicle vehicle : vehicles) {
            System.out.println("\n--- Ride Details ---");
            vehicle.getVehicleDetails();
            System.out.println("Distance : " + distance + " km");
            System.out.println("Fare     : " + vehicle.calculateFare(distance));
        }
    }

    public static void main(String[] args) {

        List<Vehicle> vehicles = new ArrayList<>();

        Vehicle car = new Car("CAR101", "Rohit", 15);
        Vehicle bike = new Bike("BIKE202", "Aman", 10);
        Vehicle auto = new Auto("AUTO303", "Suresh", 12);

        ((GPS) car).updateLocation("MG Road");
        ((GPS) bike).updateLocation("City Mall");
        ((GPS) auto).updateLocation("Railway Station");

        vehicles.add(car);
        vehicles.add(bike);
        vehicles.add(auto);

        calculateRideFare(vehicles, 8.5);
    }
}
