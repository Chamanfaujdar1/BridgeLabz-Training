// package gcr_codebase.address_book;

import java.util.*;

public class AddressBookSystem {

    private Map<String, AddressBook> addressBookMap = new HashMap<>();

    // UC6: Create new AddressBook with unique name
    public void addNewAddressBook(Scanner sc) {
        System.out.println("\n Create New Address Book");
        System.out.print("Enter Address Book Name: ");
        String name = sc.nextLine().trim();

        String key = name.toLowerCase();

        if (addressBookMap.containsKey(key)) {
            System.out.println(" Address Book with name '" + name + "' already exists!");
            return;
        }

        addressBookMap.put(key, new AddressBook());
        System.out.println(" Address Book '" + name + "' created successfully!");
    }

    public AddressBook getAddressBook(Scanner sc) {
        if (addressBookMap.isEmpty()) {
            System.out.println(" No Address Books available. Please create one first.");
            return null;
        }

        System.out.print("Enter Address Book Name: ");
        String name = sc.nextLine().trim();
        AddressBook book = addressBookMap.get(name.toLowerCase());

        if (book == null) {
            System.out.println("❌ Address Book not found with name: " + name);
        }

        return book;
    }

    public void displayAllAddressBooks() {
        System.out.println("\n Available Address Books:");

        if (addressBookMap.isEmpty()) {
            System.out.println(" No Address Books created yet.");
            return;
        }

        for (String name : addressBookMap.keySet()) {
            System.out.println(" " + name);
        }
    }

    // UC8: Search person by City across all AddressBooks
    public void searchPersonByCity(String city) {
        System.out.println("\n Searching persons in City: " + city);

        boolean found = false;

        for (Map.Entry<String, AddressBook> entry : addressBookMap.entrySet()) {
            String bookName = entry.getKey();
            AddressBook book = entry.getValue();

            for (Contact c : book.getContacts()) {
                if (c.getCity().equalsIgnoreCase(city)) {
                    found = true;
                    System.out.println(" Found in AddressBook: " + bookName + " -> " + c.getFirstName() + " " + c.getLastName());
                }
            }
        }

        if (!found) {
            System.out.println(" No persons found in city: " + city);
        }
    }

    //  UC8: Search person by State across all AddressBooks
    public void searchPersonByState(String state) {
        System.out.println("\n🔍 Searching persons in State: " + state);

        boolean found = false;

        for (Map.Entry<String, AddressBook> entry : addressBookMap.entrySet()) {
            String bookName = entry.getKey();
            AddressBook book = entry.getValue();

            for (Contact c : book.getContacts()) {
                if (c.getState().equalsIgnoreCase(state)) {
                    found = true;
                    System.out.println(" Found in AddressBook: " + bookName + " -> " + c.getFirstName() + " " + c.getLastName());
                }
            }
        }

        if (!found) {
            System.out.println(" No persons found in state: " + state);
        }
    }

    // UC9: View persons grouped by City
    public void viewPersonsByCity() {
        System.out.println("\n View Persons By City");

        Map<String, List<String>> cityMap = new HashMap<>();

        for (AddressBook book : addressBookMap.values()) {
            for (Contact c : book.getContacts()) {
                cityMap.putIfAbsent(c.getCity().toLowerCase(), new ArrayList<>());
                cityMap.get(c.getCity().toLowerCase()).add(c.getFirstName() + " " + c.getLastName());
            }
        }

        if (cityMap.isEmpty()) {
            System.out.println(" No contacts available in system!");
            return;
        }

        for (String city : cityMap.keySet()) {
            System.out.println("\nCity: " + city);
            for (String person : cityMap.get(city)) {
                System.out.println(" " + person);
            }
        }
    }

    // UC9: View persons grouped by State
    public void viewPersonsByState() {
        System.out.println("\n View Persons By State");

        Map<String, List<String>> stateMap = new HashMap<>();

        for (AddressBook book : addressBookMap.values()) {
            for (Contact c : book.getContacts()) {
                stateMap.putIfAbsent(c.getState().toLowerCase(), new ArrayList<>());
                stateMap.get(c.getState().toLowerCase()).add(c.getFirstName() + " " + c.getLastName());
            }
        }

        if (stateMap.isEmpty()) {
            System.out.println(" No contacts available in system!");
            return;
        }

        for (String state : stateMap.keySet()) {
            System.out.println("\nState: " + state);
            for (String person : stateMap.get(state)) {
                System.out.println(" " + person);
            }
        }
    }

    // UC10: Count persons by City
    public void countByCity() {
        System.out.println("\n Count Persons By City");

        Map<String, Integer> cityCount = new HashMap<>();

        for (AddressBook book : addressBookMap.values()) {
            for (Contact c : book.getContacts()) {
                String cityKey = c.getCity().toLowerCase();
                cityCount.put(cityKey, cityCount.getOrDefault(cityKey, 0) + 1);
            }
        }

        if (cityCount.isEmpty()) {
            System.out.println(" No contacts available in system!");
            return;
        }

        for (Map.Entry<String, Integer> entry : cityCount.entrySet()) {
            System.out.println("City: " + entry.getKey() + " -> Count: " + entry.getValue());
        }
    }

    // UC10: Count persons by State
    public void countByState() {
        System.out.println("\n Count Persons By State");

        Map<String, Integer> stateCount = new HashMap<>();

        for (AddressBook book : addressBookMap.values()) {
            for (Contact c : book.getContacts()) {
                String stateKey = c.getState().toLowerCase();
                stateCount.put(stateKey, stateCount.getOrDefault(stateKey, 0) + 1);
            }
        }

        if (stateCount.isEmpty()) {
            System.out.println(" No contacts available in system!");
            return;
        }

        for (Map.Entry<String, Integer> entry : stateCount.entrySet()) {
            System.out.println("State: " + entry.getKey() + " -> Count: " + entry.getValue());
        }
    }
}
