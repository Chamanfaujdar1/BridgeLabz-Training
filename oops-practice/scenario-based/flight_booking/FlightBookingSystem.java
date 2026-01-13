package flight_booking;

import java.util.*;

public class FlightBookingSystem {

    static Flight[] flights = {
            new Flight("AI101", "Delhi", "Mumbai"),
            new Flight("IN202", "Chennai", "Bangalore"),
            new Flight("SG303", "Delhi", "Kolkata")
    };

    static List<Booking> bookings = new ArrayList<>();

    static void searchFlight(String src, String dst) {
        for (Flight f : flights) {
            if (f.source.equalsIgnoreCase(src) &&
                    f.dest.equalsIgnoreCase(dst)) {
                System.out.println("Found: " + f.code);
            }
        }
    }

    static void bookFlight(String user, String code) {
        for (Flight f : flights) {
            if (f.code.equalsIgnoreCase(code)) {
                bookings.add(new Booking(user, f));
                System.out.println("Flight booked");
                return;
            }
        }
        System.out.println("Flight not found");
    }

    static void showBookings() {
        for (Booking b : bookings)
            b.display();
    }

    public static void main(String[] args) {
        searchFlight("delhi", "mumbai");
        bookFlight("Aman", "Indigo101");
        showBookings();
    }
}