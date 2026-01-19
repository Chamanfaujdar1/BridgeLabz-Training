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
			System.out.println("6. Exit");
			
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
				System.out.println("Exiting Booking Address");
				sc.close();
				return;
				
			default:
				System.out.println("Invalid choice! Please try again");
			}
		}
		
	}

}
