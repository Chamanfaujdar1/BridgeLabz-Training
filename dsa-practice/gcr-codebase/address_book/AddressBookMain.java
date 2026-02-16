// package gcr_codebase.address_book;

import java.util.*;

public class AddressBookMain {

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program");
		Scanner sc = new Scanner(System.in);
		
		// UC6 - Multiple Address Books System
		AddressBookSystem system = new AddressBookSystem();
		
		while(true){
			System.out.println("\n========== Address Book System Menu ==========");
			System.out.println("1. Create New Address Book");
			System.out.println("2. Select Address Book & Manage Contacts");
			System.out.println("3. Display All Address Books");
			System.out.println("4. Search Person by City (Across All Books)");
			System.out.println("5. Search Person by State (Across All Books)");
			System.out.println("6. View Persons by City");
			System.out.println("7. View Persons by State");
			System.out.println("8. Count Persons by City");
			System.out.println("9. Count Persons by State");
			System.out.println("10. Exit");
			System.out.println("==============================================");
			
			System.out.print("Enter your choice: ");
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				system.addNewAddressBook(sc);
				break;
				
			case 2:
				AddressBook selectedBook = system.getAddressBook(sc);
				if (selectedBook != null) {
					manageAddressBook(selectedBook, sc);
				}
				break;
				
			case 3:
				system.displayAllAddressBooks();
				break;
				
			case 4:
				System.out.print("Enter City to search: ");
				String city = sc.nextLine();
				system.searchPersonByCity(city);
				break;
				
			case 5:
				System.out.print("Enter State to search: ");
				String state = sc.nextLine();
				system.searchPersonByState(state);
				break;
				
			case 6:
				system.viewPersonsByCity();
				break;
				
			case 7:
				system.viewPersonsByState();
				break;
				
			case 8:
				system.countByCity();
				break;
				
			case 9:
				system.countByState();
				break;
				
			case 10:
				System.out.println("Exiting Address Book System. Goodbye!");
				sc.close();
				return;
				
			default:
				System.out.println("Invalid choice! Please try again");
			}
		}
	}
	
	// UC1-UC5, UC11-UC15 - Manage individual Address Book
	private static void manageAddressBook(AddressBook addressBook, Scanner sc) {
		while(true){
			System.out.println("\n========== Address Book Menu ==========");
			System.out.println("1. Add Contact");
			System.out.println("2. Add Multiple Contacts");
			System.out.println("3. Edit Contact");
			System.out.println("4. Delete Contact");
			System.out.println("5. Display All Contacts");
			System.out.println("6. Sort Contacts By Name");
			System.out.println("7. Sort By City");
			System.out.println("8. Sort By State");
			System.out.println("9. Sort By Zip");
			System.out.println("10. Save to Text File");
			System.out.println("11. Read from Text File");
			System.out.println("12. Save to CSV File");
			System.out.println("13. Read from CSV File");
			System.out.println("14. Save to JSON File");
			System.out.println("15. Read from JSON File");
			System.out.println("16. Back to Main Menu");
			System.out.println("=======================================");
			
			System.out.print("Enter your choice: ");
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				addressBook.addContact(sc);
				break;
				
			case 2:
				addressBook.addMultipleContacts(sc);
				break;
				
			case 3:
				addressBook.editContact(sc);
				break;
				
			case 4:
				addressBook.deleteContact(sc);
				break;
				
			case 5:
				addressBook.displayDetails();
				break;

			case 6:
				addressBook.sortContactsByName();
				break;

			case 7:
				addressBook.sortByCity();
				break;

			case 8:
				addressBook.sortByState();
				break;

			case 9:
				addressBook.sortByZip();
				break;

			case 10:
				FileIOService.writeToFile(addressBook.getContactList());
				break;

			case 11:
				FileIOService.readFromFile();
				break;

			case 12:
				CSVService.writeToCSV(addressBook.getContactList());
				break;

			case 13:
				CSVService.readFromCSV();
				break;

			case 14:
				JSONService.writeToJSON(addressBook.getContactList());
				break;

			case 15:
				JSONService.readFromJSON();
				break;
				
			case 16:
				System.out.println("Returning to Main Menu...");
				return;
				
			default:
				System.out.println("Invalid choice! Please try again");
			}
		}
	}
}
