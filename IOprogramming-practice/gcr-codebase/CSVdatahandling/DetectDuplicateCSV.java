package collections_practice.gcr_codebase.csv_data_handling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class DetectDuplicateCSV {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\DELL\\eclipse-workspace\\BridgeLabzTraining_Duplicate\\src\\collections_practice\\gcr_codebase\\csv_data_handling\\students.csv";
        Set<String> seenIds = new HashSet<>();
        boolean duplicateFound = false;

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

                String id = data[0];

                // If ID already exists → duplicate
                if (!seenIds.add(id)) {
                    if (!duplicateFound) {
                        System.out.println("Duplicate Records Found:");
                        duplicateFound = true;
                    }
                    System.out.println("Row " + rowNumber + " → " + line);
                }
            }

            if (!duplicateFound) {
                System.out.println("No duplicate records found.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

