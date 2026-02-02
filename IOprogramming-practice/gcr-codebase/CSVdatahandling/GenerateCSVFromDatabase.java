package collections_practice.gcr_codebase.csv_data_handling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.FileWriter;
import java.io.IOException;

public class GenerateCSVFromDatabase {

    // Update these as per your DB
    private static final String DB_URL = "jdbc:mysql://localhost:3306/companydb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    public static void main(String[] args) {

        String csvFile = "C:\\Users\\DELL\\eclipse-workspace\\BridgeLabzTraining_Duplicate\\src\\collections_practice\\gcr_codebase\\csv_data_handling\\employees_report.csv";
        String query = "SELECT emp_id, name, department, salary FROM employees";

        try (
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            FileWriter fw = new FileWriter(csvFile)
        ) {

            // Write CSV header
            fw.write("Employee ID,Name,Department,Salary\n");

            // Write rows
            while (rs.next()) {
                fw.write(
                    rs.getInt("emp_id") + "," +
                    rs.getString("name") + "," +
                    rs.getString("department") + "," +
                    rs.getDouble("salary") + "\n"
                );
            }

            System.out.println("✅ CSV report generated successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

