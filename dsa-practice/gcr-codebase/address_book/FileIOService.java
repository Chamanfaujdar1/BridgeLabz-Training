import java.io.*;
import java.util.*;

public class FileIOService {

    private static final String FILE_NAME = "AddressBook.txt";

    // WRITE contacts to file
    public static void writeToFile(ArrayList<Contact> contacts) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Contact c : contacts) {
                writer.write(c.toString());
                writer.newLine();
            }

            System.out.println("Contacts saved to file successfully!");

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // READ contacts from file
    public static void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;
            System.out.println("\nContacts from File:");

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
