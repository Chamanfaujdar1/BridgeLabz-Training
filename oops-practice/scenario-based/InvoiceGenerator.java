class InvalidInvoiceFormatException extends Exception {
    public InvalidInvoiceFormatException(String message) {
        super(message);
    }
}

public class InvoiceGenerator {

    public static String[] parseInvoice(String input)
            throws InvalidInvoiceFormatException {

        if (input == null || input.trim().isEmpty()) {
            throw new InvalidInvoiceFormatException(
                "Invoice input cannot be empty"
            );
        }

        String[] tasks = input.split(",");

        for (String task : tasks) {
            if (!task.contains("-") || !task.matches(".*\\d+.*")) {
                throw new InvalidInvoiceFormatException(
                    "Invalid task format: " + task.trim()
                );
            }
        }

        return tasks;
    }

    public static int getTotalAmount(String[] tasks)
            throws InvalidInvoiceFormatException {

        int total = 0;

        for (String task : tasks) {
            try {
                String[] parts = task.split("-");

                if (parts.length != 2) {
                    throw new InvalidInvoiceFormatException(
                        "Missing dash (-) in task: " + task.trim()
                    );
                }

                String amountPart = parts[1].trim();
                String[] amountTokens = amountPart.split(" ");

                int amount = Integer.parseInt(amountTokens[0]);
                total += amount;

            } catch (NumberFormatException e) {
                throw new InvalidInvoiceFormatException(
                    "Invalid amount in task: " + task.trim()
                );
            }
        }

        return total;
    }

    public static void main(String[] args) {

        String input =
            "Logo Design - 3000 INR, Web Page - 4500 INR";

        try {
            String[] tasks = parseInvoice(input);

            System.out.println("Invoice Details:");
            for (String task : tasks) {
                System.out.println("- " + task.trim());
            }

            int totalAmount = getTotalAmount(tasks);
            System.out.println("\nTotal Invoice Amount: ₹" + totalAmount);

        } catch (InvalidInvoiceFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
