import java.util.*;

class Vehicle{
    protected String vehicleNumber;
    protected String model;
    protected double pricePerDay;

    public Vehicle(String vehicleNumber, String model, double pricePerDay){
        this.vehicleNumber = vehicleNumber;
        this.model = model;
        this.pricePerDay = pricePerDay;
    }

    public void displayInfo(){
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Model: " + model);
        System.out.println("Price Per Day: " + pricePerDay);
    }
}

class Bike extends Vehicle implements IRentable{
    public Bike(String vehicleNumber, String model, double pricePerDay){
        super(vehicleNumber, model, pricePerDay);
    }

    public double calculateRent(int days){
        return days * pricePerDay;
    }
}

class Car extends Vehicle implements IRentable{
    public Car(String vehicleNumber, String model, double pricePerDay){
        super(vehicleNumber, model, pricePerDay);
    }

    public double calculateRent(int days){
        return (days * pricePerDay) + 300;
    }
}

class Truck extends Vehicle implements IRentable{
    public Truck(String vehicleNumber, String model, double pricePerDay){
        super(vehicleNumber, model, pricePerDay);
    }
    public double calculateRent(int days){
        return (days * pricePerDay) + 500;
    }
}

interface IRentable{
    double calculateRent(int days);
}

class Customer{
    private int customerId;
    private String name;

    public Customer(int customerId, String name){
        this.customerId = customerId;
        this.name = name;
    }

    public void displayCustomer(){
        System.out.println("Customer Id: " + customerId);
        System.out.println("Customer Name: " + name);
    }
}

public class VehicleRentalApplication {
    static List<Vehicle> vehicles = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        while(true){
            System.out.println("-- Vehicle Rental System --");
            System.out.println("1. Add Vehicle");
            System.out.println("2. View Vehicles");
            System.out.println("3. Update Vehicle Price");
            System.out.println("4. Delete Vehicle");
            System.out.println("5. Calculate Rent");
            System.out.println("6. Exit");

            int choice = sc.nextInt();

            switch(choice){
                case 1 -> addVehicle();
                case 2 -> viewVehicles();
                case 3 -> updateVehicle();
                case 4 -> deleteVehicle();
                case 5 -> calculateRent();
                case 6 -> {
                    System.out.println("Thank you");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    static void addVehicle(){
        System.out.println("1. Bike  2. Car  3. Truck");
        int type = sc.nextInt();

        System.out.print("Vehicle Number: ");
        String number = sc.next();
        System.out.print("Model: ");
        String model = sc.next();
        System.out.print("Price per day: ");
        double price = sc.nextDouble();

        Vehicle v = switch (type) {
            case 1 -> new Bike(number, model, price);
            case 2 -> new Car(number, model, price);
            case 3 -> new Truck(number, model, price);
            default -> null;
        };

        if(v != null){
            vehicles.add(v);
            System.out.println("Vehicle added successfully");
        }
    }

    static void viewVehicles(){

        for(Vehicle v : vehicles){
            v.displayInfo();
            System.out.println("-------");
        }
    }

    static void updateVehicle(){
        System.out.print("Enter Vehicle Number: ");
        String number = sc.next();

        for (Vehicle v : vehicles) {
            if (v.vehicleNumber.equals(number)) {
                System.out.print("Enter new price: ");
                v.pricePerDay = sc.nextDouble();
                System.out.println("Price updated");
                return;
            }
        }
        System.out.println("Vehicle not found");
    }

    static void deleteVehicle(){
        System.out.print("Enter Vehicle Number: ");
        String number = sc.next();

        Iterator<Vehicle> itr = vehicles.iterator();
        while(itr.hasNext()){
            if(itr.next().vehicleNumber.equals(number)){
                itr.remove();
                System.out.println("Vehicle removed");
                return;
            }
        }
        System.out.println("Vehicle not found");
    }

    static void calculateRent(){
        System.out.print("Enter Vehicle Number: ");
        String number = sc.next();
        System.out.print("Enter days: ");
        int days = sc.nextInt();

        for(Vehicle v : vehicles){
            if(v.vehicleNumber.equals(number) && v instanceof IRentable r){
                System.out.println("Total Rent: " + r.calculateRent(days));
                return;
            }
        }
        System.out.println("Vehicle not found");
    }
}
