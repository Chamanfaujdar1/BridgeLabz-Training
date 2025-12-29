import java.util.Scanner;

public class MovieTicketBookingApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            int basePrice = 0;
            int seatPrice = 0;
            int snackPrice = 0;

            System.out.println("\nMovie Ticket Booking");
            System.out.print("Enter movie type (Action / Comedy / Drama or Exit): ");
            String movieType = scanner.next();

            if (movieType.equalsIgnoreCase("Exit")) {
                System.out.println("Thank you for using Movie Ticket Booking App");
                break;
            }

            switch (movieType.toLowerCase()) {
                case "action":
                    basePrice = 200;
                    break;
                case "comedy":
                    basePrice = 150;
                    break;
                case "drama":
                    basePrice = 180;
                    break;
                default:
                    System.out.println("Invalid movie type!");
                    continue;
            }

            System.out.print("Enter seat type (Gold / Silver): ");
            String seatType = scanner.next();

            if (seatType.equalsIgnoreCase("gold")) {
                seatPrice = 100;
            } else if (seatType.equalsIgnoreCase("silver")) {
                seatPrice = 50;
            } else {
                System.out.println("Invalid seat type!");
                continue;
            }

            System.out.print("Do you want snacks? (Yes / No): ");
            String snacks = scanner.next();

            if (snacks.equalsIgnoreCase("yes")) {
                snackPrice = 80;
            }

            int totalBill = basePrice + seatPrice + snackPrice;

            System.out.println("\nBooking Summary");
            System.out.println("Movie Type  : " + movieType);
            System.out.println("Seat Type   : " + seatType);
            System.out.println("Snacks      : " + snacks);
            System.out.println("Total Amount: ₹" + totalBill);
        }

        scanner.close();
    }
}
