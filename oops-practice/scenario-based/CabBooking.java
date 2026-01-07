import java.util.*;

class NoDriverAvailableException extends Exception{
    public NoDriverAvailableException(String message){
        super(message);
    }
}

interface FareCalculator{
    double calculateFare(double distance);
}

class NormalFareCalculator implements FareCalculator{
    public double calculateFare(double distance){
        return distance * 8;
    }
}

class ExtremeFareCalculator implements FareCalculator{
    public double calculateFare(double distance){
        return distance * 15;
    }
}

class User{
    int userId;
    String name;
    String mobileNo;

    public User(int userId, String name, String mobileNo){
        this.userId = userId;
        this.name = name;
        this.mobileNo = mobileNo;
    }
}

class Driver{
    int driverId;
    String driverName;
    boolean available;

    public Driver(int driverId, String driverName){
        this.driverId = driverId;
        this.driverName = driverName;
        this.available = true;
    }
}

class Ride{
    int rideId;
    User user;
    Driver driver;
    double distance;
    double fare;
    String status;

    public Ride(int rideId, User user, double distance){
        this.rideId = rideId;
        this.user = user;
        this.distance = distance;
        this.status = "BOOKED";
    }
}

public class CabBooking {
    static List<Driver> drivers = new ArrayList<>();
    static List<Ride> rideHistory = new ArrayList<>();

    static int rideCounter = 1;

    public static Driver assignDriver() throws NoDriverAvailableException{
        for(Driver d : drivers){
            if(d.available){
                d.available = false;
                return d;
            }
        }
        throw new NoDriverAvailableException("no drivers available currently");
    }

    public static Ride bookRide(User user, double distance, boolean isPeakHour) throws NoDriverAvailableException{
        Ride ride = new Ride(rideCounter++, user, distance);
        ride.driver = assignDriver();

        FareCalculator calculator;
        if (isPeakHour) {
            calculator = new ExtremeFareCalculator();
        } else {
            calculator = new NormalFareCalculator();
        }

        ride.fare = calculator.calculateFare(distance);
        ride.status = "ONGOING";

        rideHistory.add(ride);
        return ride;
    }

    public static void completeRide(Ride ride) {
        ride.status = "COMPLETED";
        ride.driver.available = true;
    }

    public static void showRideHistory() {
        System.out.println("\n--- Ride History ---");
        for (Ride r : rideHistory) {
            System.out.println(
                    "RideID: " + r.rideId +
                    ", User: " + r.user.name +
                    ", Driver: " + r.driver.driverName +
                    ", Distance: " + r.distance +
                    ", Fare: ₹" + r.fare +
                    ", Status: " + r.status
            );
        }
    }

    public static void main(String[] args){
        drivers.add(new Driver(1, "Anuj"));
        drivers.add(new Driver(2, "Govind"));

        User user1 = new User(101, "Himanshu", "9786868676");

        try {
            System.out.println("Booking Ride...");
            Ride ride = bookRide(user1, 12.5, true);
            System.out.println("Ride Booked Successfully!");
            System.out.println("Driver: " + ride.driver.driverName);
            System.out.println("Fare: " + ride.fare);

            completeRide(ride);
            System.out.println("Ride Completed!");

        } catch (NoDriverAvailableException e) {
            System.out.println(e.getMessage());
        }

        showRideHistory();
    }
}
