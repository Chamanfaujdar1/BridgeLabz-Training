public class Vehicle {
    
    String ownerName;
    String vehicleType;
    static double registrationFee = 500.0;

    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: " + registrationFee);
        System.out.println("-------------------------");
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("System Update: Registration fee updated to " + newFee);
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Karan", "Sedan");
        Vehicle v2 = new Vehicle("Ananya", "SUV");

        System.out.println("Initial Registration Details:");
        v1.displayVehicleDetails();
        v2.displayVehicleDetails();

        Vehicle.updateRegistrationFee(750.0);

        System.out.println("\nDetails after Fee Update:");
        v1.displayVehicleDetails();
        v2.displayVehicleDetails();
    }
}