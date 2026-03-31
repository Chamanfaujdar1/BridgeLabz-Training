import java.util.*;

class InvalidPhoneNumberException extends Exception {
    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}

class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void display() {
        System.out.print(" Name : " + name);
        System.out.print(" Phone : " + phoneNumber);
    }
}
class ContactOrganizer {
    private List<Contact> contacts = new ArrayList<>();

    private void validatePhoneNumber(String phoneNumber)
            throws InvalidPhoneNumberException {

        if (!phoneNumber.matches("\\d{10}")) {
            throw new InvalidPhoneNumberException(
                "Phone number must be exactly 10 digits"
            );
        }
    }

    public void addContact(String name, String phoneNumber)
            throws InvalidPhoneNumberException {

        validatePhoneNumber(phoneNumber);

        for (Contact c : contacts) {
            if (c.getPhoneNumber().equals(phoneNumber)) {
                System.out.println("Duplicate contact not allowed!");
                return;
            }
        }

        contacts.add(new Contact(name, phoneNumber));
        System.out.println("Contact added successfully");
    }
    public void deleteContact(String phoneNumber) {
        Iterator<Contact> iterator = contacts.iterator();

        while (iterator.hasNext()) {
            Contact c = iterator.next();
            if (c.getPhoneNumber().equals(phoneNumber)) {
                iterator.remove();
                System.out.println("Contact deleted successfully");
                return;
            }
        }

        System.out.println("Contact not found");
    }
    public void searchContact(String phoneNumber) {
        for (Contact c : contacts) {
            if (c.getPhoneNumber().equals(phoneNumber)) {
                System.out.println("Contact Found:");
                c.display();
                return;
            }
        }
        System.out.println("Contact not found");
    }

    // Display all contacts
    public void displayAll() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available");
            return;
        }

        System.out.println("\n--- Contact List ---");
        for (Contact c : contacts) {
            c.display();
        }
    }
}

public class PhoneContactOrganizer {
    public static void main(String[] args) {

        ContactOrganizer organizer = new ContactOrganizer();

        try {
            organizer.addContact("Ravi", "9876543210");
            organizer.addContact("Amit", "9123456789");

            organizer.addContact("Invalid", "12345");

        } catch (InvalidPhoneNumberException e) {
            System.out.println("Error: " + e.getMessage());
        }

        organizer.searchContact("9876543210");
        organizer.deleteContact("9123456789");
        organizer.displayAll();
    }
}
