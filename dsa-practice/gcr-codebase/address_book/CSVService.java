// package gcr_codebase.address_book;

import java.io.*;
import java.util.*;

public class CSVService {
    
    private static final String CSV_FILE = "AddressBook.csv";
    private static final String DELIMITER = ",";
    
    // UC14 - Write contacts to CSV file
    public static void writeToCSV(ArrayList<Contact> contacts) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE))) {
            
            // Write header
            writer.write("FirstName,LastName,Address,City,State,Zip,PhoneNumber,Email");
            writer.newLine();
            
            // Write contact data
            for (Contact c : contacts) {
                writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s",
                    c.getFirstName(),
                    c.getLastName(),
                    c.getAddress(),
                    c.getCity(),
                    c.getState(),
                    c.getZip(),
                    c.getPhoneNumber(),
                    c.getEmail()
                ));
                writer.newLine();
            }
            
            System.out.println("Contacts saved to CSV file successfully!");
            
        } catch (IOException e) {
            System.out.println("Error writing to CSV file: " + e.getMessage());
        }
    }
    
    // UC14 - Read contacts from CSV file
    public static ArrayList<Contact> readFromCSV() {
        ArrayList<Contact> contacts = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE))) {
            
            String line;
            boolean isHeader = true;
            
            System.out.println("\nContacts from CSV File:");
            
            while ((line = reader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                
                String[] data = line.split(DELIMITER);
                
                if (data.length == 8) {
                    Contact contact = new Contact(
                        data[0], data[1], data[2], data[3],
                        data[4], data[5], data[6], data[7]
                    );
                    contacts.add(contact);
                    System.out.println(contact);
                }
            }
            
            System.out.println("Total contacts read: " + contacts.size());
            
        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }
        
        return contacts;
    }
}
