package collections_practice.gcr_codebase.csv_data_handling;

import java.io.*;
import java.util.*;

public class SearchRecord {

	public static void main(String[] args) {
		String filePath = "C:\\Users\\DELL\\eclipse-workspace\\BridgeLabzTraining_Duplicate\\src\\collections_practice\\gcr_codebase\\csv_data_handling\\employees.csv";
        String searchName = "Anita"; // name to search
        boolean found = false;
        
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
        	String line;
            boolean isHeader = true;
            
            while ((line = br.readLine()) != null) {

                // Skip header
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] data = line.split(",");

                String name = data[1];

                if (name.equalsIgnoreCase(searchName)) {
                    System.out.println("Employee Found!");
                    System.out.println("Name: " + name);
                    System.out.println("Department: " + data[2]);
                    System.out.println("Salary: " + data[3]);
                    found = true;
                    break;
                }
            }
            
            if (!found) {
                System.out.println("Employee not found.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        	
	}

}
