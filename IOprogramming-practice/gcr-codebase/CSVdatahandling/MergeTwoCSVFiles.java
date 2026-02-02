package collections_practice.gcr_codebase.csv_data_handling;

import java.io.*;
import java.util.*;

public class MergeTwoCSVFiles {

    // Inner class to store student data
    static class Student {
        String id;
        String name;
        String age;
        String marks;
        String grade;

        Student(String id, String name, String age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {

        String file1 = "C:\\Users\\DELL\\eclipse-workspace\\BridgeLabzTraining_Duplicate\\src\\collections_practice\\gcr_codebase\\csv_data_handling\\students1.csv";
        String file2 = "C:\\Users\\DELL\\eclipse-workspace\\BridgeLabzTraining_Duplicate\\src\\collections_practice\\gcr_codebase\\csv_data_handling\\students2.csv";
        String outputFile = "merged_students.csv";

        // Map to store students using ID as key
        Map<String, Student> studentMap = new HashMap<>();

        // Step 1: Read students1.csv
        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] data = line.split(",");
                Student student = new Student(data[0], data[1], data[2]);
                studentMap.put(data[0], student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Step 2: Read students2.csv and merge data
        try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] data = line.split(",");
                Student student = studentMap.get(data[0]);

                if (student != null) {
                    student.marks = data[1];
                    student.grade = data[2];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Step 3: Write merged data to new CSV
        try (FileWriter fw = new FileWriter(outputFile)) {

            fw.write("ID,Name,Age,Marks,Grade\n");

            for (Student s : studentMap.values()) {
                fw.write(
                        s.id + "," +
                        s.name + "," +
                        s.age + "," +
                        s.marks + "," +
                        s.grade + "\n"
                );
            }

            System.out.println("CSV files merged successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

