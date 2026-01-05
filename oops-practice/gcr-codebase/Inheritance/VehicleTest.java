class Vehicle{
    int maxSpeed;
    String fuelType;

    Vehicle(int maxSpeed, String fuelType){
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    void displayInfo(){
        System.out.println("Max Speed: " + maxSpeed);
        System.out.println("Fuel Type: " + fuelType);
    }
}

class Car extends Vehicle{
    int numberOfSeats;
    Car(int maxSpeed, String fuelType, int numberOfSeats){
        super(maxSpeed, fuelType);
        this.numberOfSeats = numberOfSeats;
    }
    void displayInfo(){
        super.displayInfo();
        System.out.println("Number of seats: " + numberOfSeats);
    }
}

class Truck extends Vehicle{
    int loadCapacity;
    Truck(int maxSpeed, String fuelType, int loadCapacity){
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }

    void displayInfo(){
        super.displayInfo();
        System.out.println("Load Capacity: " + loadCapacity);
    }
}

class MotorCycle extends Vehicle{
    String model;
    MotorCycle(int maxSpeed, String fuelType, String model){
        super(maxSpeed, fuelType);
        this.model = model;
    }

    void displayInfo(){
        super.displayInfo();
        System.out.println("Model Of Bike: " + model);
    }
}

public class VehicleTest {
    public static void main(String[] args){
        Vehicle[] vehicles = new Vehicle[3];

        vehicles[0] = new Car(220, "Petrol", 5);
        vehicles[1] = new Truck(110, "Diesel", 15.5);
        vehicles[2] = new Motorcycle(180, "Petrol", "Hero");

        System.out.println("=== Transport Fleet Status ===");
        for (Vehicle v : vehicles) {
            v.displayInfo();
        } 
    }
}
