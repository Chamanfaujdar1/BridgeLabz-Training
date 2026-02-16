// package gcr_codebase.address_book;

import java.util.*;
public class AddressBookProblem {

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program");
		Scanner sc = new Scanner(System.in);
		
		AddressBook addressBook = new AddressBook();
		
		while(true){
			System.out.println("Address Book Menu");
			System.out.println("1. Add Contact");
			System.out.println("2. Add Multiple Contacts");
			System.out.println("3. Edit Contacts");
			System.out.println("4. Delete contacts");
			System.out.println("5. Display Contacts");
			System.out.println("6. Sort Contacts By Name");
			System.out.println("7. Sort By City");
			System.out.println("8. Sort By State");
            System.out.println("9. Sort By Zip");
			System.out.println("10. Save Contacts to File");
			System.out.println("11. Read Contacts from File");
			System.out.println("12. Exit");
			
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
				System.out.println("Exiting Booking Address");
				sc.close();
				return;
				
			default:
				System.out.println("Invalid choice! Please try again");
			}
		}
		
	}

}
