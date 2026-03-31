package collections_practice.gcr_codebase.csv_data_handling;

import java.io.IOException;
import java.io.*;

public class FilterRecords {

	public static void main(String[] args) {
		String filePath = "C:\\Users\\DELL\\eclipse-workspace\\BridgeLabzTraining_Duplicate\\src\\collections_practice\\gcr_codebase\\csv_data_handling\\students.csv";
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
			String line;
            boolean isHeader = true;

            System.out.println("Students scoring more than 80:");
            
            while ((line = br.readLine()) != null) {

                // Skip header
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] data = line.split(",");

                int marks = Integer.parseInt(data[3]);

                if (marks > 80) {
                    System.out.println(
                        "ID: " + data[0] +
                        ", Name: " + data[1] +
                        ", Age: " + data[2] +
                        ", Marks: " + marks
                    );
                }
            }
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
