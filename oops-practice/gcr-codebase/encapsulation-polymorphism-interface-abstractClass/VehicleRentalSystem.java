import java.util.*;

abstract class Vehicle{
    private String vehicleNumber;
    private String type;
    protected double rentalRate;

    private String insurancePolicyNumber;

    public Vehicle(String vehicleNumber, String type, double rentalRate, String insurancePolicyNumber){
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    public abstract double calculateRentalCost(int days);

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    protected String getInsurancePolicyNumber() {
        return insurancePolicyNumber;
    }
}

interface Insurable {
    double calculateInsurance(int days);
    String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable {

    public Car(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Car", rentalRate, policyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    @Override
    public double calculateInsurance(int days) {
        return 200 * days;
    }

    @Override
    public String getInsuranceDetails() {
        return "Car insurance applied";
    }
}

class Bike extends Vehicle implements Insurable {

    public Bike(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Bike", rentalRate, policyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    @Override
    public double calculateInsurance(int days) {
        return 100 * days;
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike insurance applied";
    }
}

class Truck extends Vehicle implements Insurable {

    public Truck(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Truck", rentalRate, policyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        return (rentalRate * days) + 1000;
    }

    @Override
    public double calculateInsurance(int days) {
        return 400 * days;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck insurance applied";
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {

        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("MH12AB1234", 1500, "CAR-INS-101"));
        vehicles.add(new Bike("MH14XY5678", 500, "BIKE-INS-202"));
        vehicles.add(new Truck("MH20TR9999", 3000, "TRUCK-INS-303"));

        int rentalDays = 3;

        for (Vehicle vehicle : vehicles) {

            double rentalCost = vehicle.calculateRentalCost(rentalDays);
            double insuranceCost = 0;

            if (vehicle instanceof Insurable) {
                insuranceCost = ((Insurable) vehicle).calculateInsurance(rentalDays);
            }

            System.out.println("Vehicle Type : " + vehicle.getType());
            System.out.println("Vehicle No   : " + vehicle.getVehicleNumber());
            System.out.println("Rental Cost : " + rentalCost);
            System.out.println("Insurance   : " + insuranceCost);
            System.out.println("Total Cost  : " + (rentalCost + insuranceCost));
            System.out.println("-------------------");
        }
    }
}
