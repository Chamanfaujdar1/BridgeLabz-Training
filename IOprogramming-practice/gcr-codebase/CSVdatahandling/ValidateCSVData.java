package collections_practice.gcr_codebase.csv_data_handling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class ValidateCSVData {

    private static final String EMAIL_REGEX =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final String PHONE_REGEX =
            "^\\d{10}$";

    public static void main(String[] args) {

        String filePath = "C:\\Users\\DELL\\eclipse-workspace\\BridgeLabzTraining_Duplicate\\src\\collections_practice\\gcr_codebase\\csv_data_handling\\users.csv";

        Pattern emailPattern = Pattern.compile(EMAIL_REGEX);
        Pattern phonePattern = Pattern.compile(PHONE_REGEX);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            int rowNumber = 1;

            while ((line = br.readLine()) != null) {

                // Skip header
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                rowNumber++;
                String[] data = line.split(",");

                String email = data[2];
                String phone = data[3];

                boolean valid = true;
                StringBuilder error = new StringBuilder();

                if (!emailPattern.matcher(email).matches()) {
                    valid = false;
                    error.append("Invalid Email format; ");
                }

                if (!phonePattern.matcher(phone).matches()) {
                    valid = false;
                    error.append("Invalid Phone number (must be 10 digits); ");
                }

                if (!valid) {
                    System.out.println("❌ Row " + rowNumber + " Error:");
                    System.out.println("   Data: " + line);
                    System.out.println("   Reason: " + error);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

