package collections_practice.gcr_codebase.csv_data_handling;

import java.io.*;
import java.util.*;

class Employee {
    String id;
    String name;
    String department;
    int salary;

    Employee(String id, String name, String department, int salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}

public class SortCSVBySalary {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\DELL\\eclipse-workspace\\BridgeLabzTraining_Duplicate\\src\\collections_practice\\gcr_codebase\\csv_data_handling\\employees.csv";
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {

                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] data = line.split(",");
                employees.add(new Employee(
                        data[0],
                        data[1],
                        data[2],
                        Integer.parseInt(data[3])
                ));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Sort by salary descending
        employees.sort((e1, e2) -> Integer.compare(e2.salary, e1.salary));

        System.out.println("Top 5 Highest-Paid Employees:");
        for (int i = 0; i < Math.min(5, employees.size()); i++) {
            Employee e = employees.get(i);
            System.out.println(
                e.name + " | " + e.department + " | Salary: " + e.salary
            );
        }
    }
}

