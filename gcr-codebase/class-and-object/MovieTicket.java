class MovieTicket {
    String movieName;
    String seatNumber;
    double price;
    boolean isBooked; // Tracks the state of the ticket

    // Constructor
    MovieTicket() {
        this.isBooked = false;
    }

    // Method to book a ticket
    public void bookTicket(String movieName, String seatNumber, double price) {
        if (!isBooked) {
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.price = price;
            this.isBooked = true;
            System.out.println("Ticket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: $" + price);
        } else {
            System.out.println("House full!!! sorry..... Ticket already booked");
        }
    }

    // Method to display details
    public void displayDetails() {
        if (!isBooked) {
            System.out.println("Ticket have not booked yet....");
        } else {
            System.out.println("Ticket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: $" + price);
        }
    }

    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket();

        // 1. Try displaying before booking
        ticket.displayDetails();

        // 2. First successful booking
        ticket.bookTicket("Dragon", "A10", 120.0);

        // 3. Attempting to book the same ticket/seat again
        ticket.bookTicket("Dragon", "A10", 120.0);
        ticket.bookTicket("Dragon", "A10", 120.0);

        // 4. Final display of details
        ticket.displayDetails();
    }
}