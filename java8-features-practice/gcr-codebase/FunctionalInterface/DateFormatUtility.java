import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatUtility {

    interface DateUtils {

        static String formatDate(LocalDate date, String pattern) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            return date.format(formatter);
        }
    }

    public static void main(String[] args) {

        LocalDate invoiceDate = LocalDate.now();

        String format1 = DateUtils.formatDate(invoiceDate, "dd-MM-yyyy");
        String format2 = DateUtils.formatDate(invoiceDate, "MM/dd/yyyy");
        String format3 = DateUtils.formatDate(invoiceDate, "yyyy-MM-dd");

        System.out.println("Invoice Date Formats:");
        System.out.println(format1);
        System.out.println(format2);
        System.out.println(format3);
    }
}
