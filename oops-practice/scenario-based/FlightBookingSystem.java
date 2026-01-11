import java.util.*;

class Flight{
    String flightId;
    String source;
    String destination;
    double price;

    public Flight(String flightId, String source, String destination, double price){
        this.flightId = flightId;
        this.source = source;
        this.destination = destination;
        this.price = price;
    }

    void displayFlight(){
        System.out.println("Flight ID: " + flightId);
        System.out.println("Source: " + source);
        System.out.println("Destination: " + destination);
        System.out.println("Price: " + price);
    }
}

class Booking{
    String bookingId;
    String passengerName;
    Flight flight;

    public Booking(String bookingId, String passengerName, Flight flight){
        this.bookingId = bookingId;
        this.passengerName = passengerName;
        this.flight = flight;
    }

    void displayBooking(){
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Passenger Name: " + passengerName);
        flight.displayFlight();
        System.out.println("-----");
    }
}

public class FlightBookingSystem {
    static Flight[] flights = {
        new Flight("F101", "Bangalore", "Mumbai", 3000),
        new Flight("F102", "Pune", "Delhi", 6000),
        new Flight("F103", "Chennai", "Delhi", 10000)
    };

    static List<Booking> bookings = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        while(true){
            System.out.println("-- Flight Booking System --");
            System.out.println("1. Search Flights");
            System.out.println("2. Book Flight");
            System.out.println("3. View Bookings");
            System.out.println("4. Cancel Booking");
            System.out.println("5. Exit");

            int choice = sc.nextInt();

            switch(choice){
                case 1 -> searchFlights();
                case 2 -> bookFlight();
                case 3 -> viewBookings();
                case 4 -> cancelBooking();
                case 5 -> {
                    System.out.println("Thank you");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    static void searchFlights(){
        System.out.println("Enter Starting Point: ");
        String startingPoint  = sc.next();
        System.out.println("Enter Destination: ");
        String destinationPoint = sc.next();

        boolean found = false;

        for(Flight f : flights){
            if(f.source.equalsIgnoreCase(startingPoint) && f.destination.equalsIgnoreCase(destinationPoint)){
                f.displayFlight();
                found = true;
            }
        }

        if(!found){
            System.out.println("No Flights found");
        }
    }

    static void bookFlight(){
        System.out.print("Enter Flight ID: ");
        String flightId = sc.next();
        sc.nextLine();
        System.out.print("Passenger Name: ");
        String name = sc.nextLine();

        for(Flight f : flights){
            if(f.flightId.equalsIgnoreCase(flightId)){
                String bookingId = "B" + (bookings.size() + 1);
                bookings.add(new Booking(bookingId, name, f));
                System.out.println("Booking Successful. Booking ID: " + bookingId);
                return;
            }
        }
        System.out.println("Invalid Flight ID");
    }

    static void viewBookings(){
        if(bookings.isEmpty()){
            System.out.println("Np Bookings found");
            return;
        }

        for(Booking b : bookings){
            b.displayBooking();
        }
    }

    static void cancelBooking(){
        System.out.print("Enter Booking ID: ");
        String id = sc.next();

        Iterator<Booking> itr = bookings.iterator();
        while(itr.hasNext()){
            if(itr.next().bookingId.equalsIgnoreCase(id)){
                itr.remove();
                System.out.println("Booking Cancelled");
                return;
            }
        }

        System.out.println("Booking not found");
    }
}
