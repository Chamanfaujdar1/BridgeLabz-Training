package flight_booking;

public class Booking {
    String user;
    Flight flight;

    public Booking(String user, Flight flight) {
        this.user = user;
        this.flight = flight;
    }

    void display() {
        System.out.println(user + " booked " + flight.code + " " + flight.source + "-" + flight.dest);
    }
}