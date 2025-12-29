import java.time.LocalDate;
import java.util.Scanner;

public class DateArithmetic {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a date (YYYY-MM-DD): ");
        String inputDate = sc.nextLine();
        LocalDate date = LocalDate.parse(inputDate);

        System.out.println("\nOriginal Date: " + date);
        LocalDate updatedDate = date
                .plusDays(7)
                .plusMonths(1)
                .plusYears(2);

        System.out.println("After adding 7 days, 1 month, and 2 years: " + updatedDate);
        LocalDate finalDate = updatedDate.minusWeeks(3);
        System.out.println("After subtracting 3 weeks: " + finalDate);
        sc.close();
    }
}
