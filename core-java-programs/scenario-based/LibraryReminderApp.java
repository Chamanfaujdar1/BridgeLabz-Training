import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class LibraryReminderApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int totalFine = 0;

        System.out.println("Rohan’s Library Fine Calculator\n");
        for (int book = 1; book <= 5; book++) {

            System.out.println("Book " + book);

            System.out.print("Enter due date (YYYY-MM-DD): ");
            LocalDate dueDate = LocalDate.parse(scanner.next());

            System.out.print("Enter return date (YYYY-MM-DD): ");
            LocalDate returnDate = LocalDate.parse(scanner.next());

            int fine = 0;

            if (returnDate.isAfter(dueDate)) {
                long lateDays = ChronoUnit.DAYS.between(dueDate, returnDate);
                fine = (int) lateDays * 5;
                System.out.println("Late by " + lateDays + " days. Fine: ₹" + fine);
            } else {
                System.out.println("Returned on time. No fine.");
            }

            totalFine += fine;
            System.out.println("-----------------------------");
        }

        System.out.println("Total Fine for All Books: ₹" + totalFine);
        scanner.close();
    }
}
