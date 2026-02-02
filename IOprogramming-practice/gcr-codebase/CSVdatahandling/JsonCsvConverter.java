package collections_practice.gcr_codebase.csv_data_handling;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.*;

public class JsonCsvConverter {

    static class Student {
        public int id;
        public String name;
        public int age;
        public int marks;
    }

    public static void main(String[] args) throws Exception {

        jsonToCsv("students.json", "students.csv");
        csvToJson("students.csv", "students_from_csv.json");

        System.out.println("✅ JSON ↔ CSV conversion completed");
    }

    // ---------------- JSON → CSV ----------------
    public static void jsonToCsv(String jsonFile, String csvFile) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        List<Student> students =
                mapper.readValue(new File(jsonFile), new TypeReference<List<Student>>() {});

        try (FileWriter fw = new FileWriter(csvFile)) {

            // Header
            fw.write("id,name,age,marks\n");

            for (Student s : students) {
                fw.write(
                        s.id + "," +
                        s.name + "," +
                        s.age + "," +
                        s.marks + "\n"
                );
            }
        }
    }

    // ---------------- CSV → JSON ----------------
    public static void csvToJson(String csvFile, String jsonFile) throws Exception {

        List<Map<String, String>> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            String headerLine = br.readLine();
            String[] headers = headerLine.split(",");

            String line;
            while ((line = br.readLine()) != null) {

                String[] values = line.split(",");
                Map<String, String> record = new LinkedHashMap<>();

                for (int i = 0; i < headers.length; i++) {
                    record.put(headers[i], values[i]);
                }

                data.add(record);
            }
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter()
              .writeValue(new File(jsonFile), data);
    }
}

