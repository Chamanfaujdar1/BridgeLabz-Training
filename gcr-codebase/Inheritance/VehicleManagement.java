// Superclass
class Vehicle {
    String model;
    int maxSpeed;

    Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    void displayInfo() {
        System.out.println("Model: " + model + " | Max Speed: " + maxSpeed + " km/h");
    }
}

// Interface for specific behavior
interface Refuelable {
    void refuel();
}

// Subclass 1: Standard Inheritance
class ElectricVehicle extends Vehicle {
    int batteryCapacity;

    ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
        super(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }

    void charge() {
        System.out.println(model + " is charging... Battery capacity: " + batteryCapacity + " kWh");
    }
}

// Subclass 2: Hybrid (Inheritance + Interface)
class PetrolVehicle extends Vehicle implements Refuelable {
    double fuelTankCapacity;

    PetrolVehicle(String model, int maxSpeed, double fuelTankCapacity) {
        super(model, maxSpeed);
        this.fuelTankCapacity = fuelTankCapacity;
    }

    @Override
    public void refuel() {
        System.out.println(model + " is refueling at the gas station. Tank capacity: " + fuelTankCapacity + "L");
    }
}

public class VehicleManagement {
    public static void main(String[] args) {
        ElectricVehicle tesla = new ElectricVehicle("Tesla Model 3", 225, 75);
        PetrolVehicle mustang = new PetrolVehicle("Ford Mustang", 250, 60.0);

        System.out.println("--- Fleet Management ---");
        
        // Electric Vehicle actions
        tesla.displayInfo();
        tesla.charge();
        
        System.out.println();

        // Petrol Vehicle actions
        mustang.displayInfo();
        mustang.refuel();
    }
}
