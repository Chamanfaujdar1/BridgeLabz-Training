package collections_practice.gcr_codebase.csv_data_handling;

import java.io.*;
import java.util.*;

public class ReadSCV {

	public static void main(String[] args) {
		String filePath = "C:\\Users\\DELL\\eclipse-workspace\\BridgeLabzTraining_Duplicate\\src\\collections_practice\\gcr_codebase\\csv_data_handling\\students.csv";
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
			String line;
			
			while((line = br.readLine()) != null) {
				String[] columns = line.split(",");
				System.out.println("ID: " + columns[0] + " , Name: " + columns[1] + " , Age: " + columns[2] + " , Marks: " + columns[3]);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
