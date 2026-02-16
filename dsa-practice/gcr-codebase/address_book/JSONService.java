// package gcr_codebase.address_book;

import java.io.*;
import java.util.*;

public class JSONService {
    
    private static final String JSON_FILE = "AddressBook.json";
    
    // UC15 - Write contacts to JSON file
    public static void writeToJSON(ArrayList<Contact> contacts) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(JSON_FILE))) {
            
            writer.write("[\n");
            
            for (int i = 0; i < contacts.size(); i++) {
                Contact c = contacts.get(i);
                
                writer.write("  {\n");
                writer.write("    \"firstName\": \"" + c.getFirstName() + "\",\n");
                writer.write("    \"lastName\": \"" + c.getLastName() + "\",\n");
                writer.write("    \"address\": \"" + c.getAddress() + "\",\n");
                writer.write("    \"city\": \"" + c.getCity() + "\",\n");
                writer.write("    \"state\": \"" + c.getState() + "\",\n");
                writer.write("    \"zip\": \"" + c.getZip() + "\",\n");
                writer.write("    \"phoneNumber\": \"" + c.getPhoneNumber() + "\",\n");
                writer.write("    \"email\": \"" + c.getEmail() + "\"\n");
                writer.write("  }");
                
                if (i < contacts.size() - 1) {
                    writer.write(",");
                }
                writer.write("\n");
            }
            
            writer.write("]\n");
            
            System.out.println("Contacts saved to JSON file successfully!");
            
        } catch (IOException e) {
            System.out.println("Error writing to JSON file: " + e.getMessage());
        }
    }
    
    // UC15 - Read contacts from JSON file
    public static void readFromJSON() {
        try (BufferedReader reader = new BufferedReader(new FileReader(JSON_FILE))) {
            
            String line;
            System.out.println("\nContacts from JSON File:");
            
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            
        } catch (IOException e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
        }
    }
}
