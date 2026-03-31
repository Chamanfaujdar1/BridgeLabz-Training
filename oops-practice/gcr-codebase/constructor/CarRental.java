public class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double dailyRate = 1500.0;
    double totalCost;

    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.totalCost = rentalDays * dailyRate;
    }

    public CarRental(CarRental otherRental) {
        this.customerName = otherRental.customerName;
        this.carModel = otherRental.carModel;
        this.rentalDays = otherRental.rentalDays;
        this.totalCost = otherRental.totalCost;
    }

    public void displayRentalDetails() {
        System.out.println("Customer: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Duration: " + rentalDays + " days");
        System.out.println("Total Rental Cost: " + totalCost);
        System.out.println("------------------------------");
    }

    public static void main(String[] args) {
        CarRental rental1 = new CarRental("Rahul", "Toyota Fortuner", 5);
        System.out.println("New Rental Created:");
        rental1.displayRentalDetails();

        CarRental rental2 = new CarRental(rental1);
        rental2.customerName = "Priya";
        System.out.println("Duplicate Rental (for Priya):");
        rental2.displayRentalDetails();
    }
}