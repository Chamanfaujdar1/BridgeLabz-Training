package collections_practice.gcr_codebase.csv_data_handling;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.*;

public class WriteCSV {

	public static void main(String[] args) {
		String filePath = "C:\\Users\\DELL\\eclipse-workspace\\BridgeLabzTraining_Duplicate\\src\\collections_practice\\gcr_codebase\\csv_data_handling\\employees.csv";
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))){
			bw.write("ID,Name,Department,Salary\n");
			bw.write("101,Aman,CS,50000");
			bw.write("102,Arun,Mechanical,45000");
			bw.write("103,Raman,Electrical,40000");
			bw.write("104,Karan,Electrnics,40000");
			bw.write("105,Naman,CS,60000");
			System.out.println("CSV file written successfully!");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
