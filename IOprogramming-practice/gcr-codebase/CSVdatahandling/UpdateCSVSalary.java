package collections_practice.gcr_codebase.csv_data_handling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UpdateCSVSalary {

    public static void main(String[] args) {
        String inputFile = "C:\\Users\\DELL\\eclipse-workspace\\BridgeLabzTraining_Duplicate\\src\\collections_practice\\gcr_codebase\\csv_data_handling\\employees.csv";
        String outputFile = "updated_employees.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             FileWriter fw = new FileWriter(outputFile)) {

            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {

                // Write header as-is
                if (isHeader) {
                    fw.write(line + "\n");
                    isHeader = false;
                    continue;
                }

                String[] data = line.split(",");

                String department = data[2];
                double salary = Double.parseDouble(data[3]);

                // Increase salary by 10% for IT department
                if (department.equalsIgnoreCase("IT")) {
                    salary = salary + (salary * 0.10);
                }

                // Write updated record
                fw.write(data[0] + "," + data[1] + "," +
                         department + "," + (int) salary + "\n");
            }

            System.out.println("CSV file updated successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
