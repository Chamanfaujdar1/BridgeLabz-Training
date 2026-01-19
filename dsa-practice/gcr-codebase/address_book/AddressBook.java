// package gcr_codebase.address_book;

import java.util.*;

public class AddressBook {
	private ArrayList<Contact> contactList = new ArrayList<>();
	
	public void addContact(Scanner sc) {
		System.out.println("Add new Contact");
		
		System.out.print("Enter First Name: ");
		String firstName = sc.nextLine();
		
		System.out.print("Enter Last Name: ");
		String lastName = sc.nextLine();
		
		System.out.print("Enter address: ");
		String address = sc.nextLine();
		
		System.out.print("Enter City: ");
		String city = sc.nextLine();
		
		System.out.print("Enter State: ");
		String state = sc.nextLine();
		
		System.out.print("Enter Zip: ");
		String zip = sc.nextLine();
		
		System.out.print("Enter Phone Number: ");
		String number = sc.nextLine();
		
		System.out.print("Enter Email: ");
		String email = sc.nextLine();
		
		Contact contact = new Contact(firstName, lastName, address, city, state, zip, number, email);
		contactList.add(contact);
		
		System.out.println("Contacts added successfully");
	}
	
	public void addMultipleContacts(Scanner sc) {
		System.out.println("Add Multiple Contacts");
		
		while(true) {
			addContact(sc);
			
			System.out.print("\nDo you want to add another contact? (yes/no): ");
			String choice = sc.nextLine();
			
			if(!choice.equalsIgnoreCase("yes")) {
				System.out.println("Finished adding contacts!");
				break;
			}
		}
	}
	
	public void editContact(Scanner sc) {
		System.out.println("Edit Contact");
		
		System.out.print("Enter first name of contact to edit: "); 
		
		String firstName = sc.nextLine();
		
		boolean found = false;
		
		for(Contact contact : contactList) {
			if(contact.getFirstName().equalsIgnoreCase(firstName)) {
				found = true;
				
				System.out.println("Contact found. Enter new details");
				
				System.out.print("Enter new Address: ");
				contact.setAddress(sc.nextLine());
				
				System.out.print("Enter new city: ");
				contact.setCity(sc.nextLine());
				
				System.out.print("Enter new state: ");
				contact.setState(sc.nextLine());
				
				System.out.print("Enter new zip: ");
				contact.setZip(sc.nextLine());
				
				System.out.print("Enter new phone number: ");
				contact.setPhonenumber(sc.nextLine());
				
				System.out.print("Enter new email: ");
				contact.setEmail(sc.nextLine());
				
				System.out.print("Contact Updated Successfully");
				return;
			}
		}
		
		if(!found) {
			System.out.print("Contact not found with the name " + firstName);
		}
	}
	
	public void deleteContact(Scanner sc) {
		System.out.println("\n🗑 Delete Contact");
        System.out.print("Enter first name of contact to delete: ");
        String firstName = sc.nextLine();

        boolean found = false;

        Iterator<Contact> iterator = contactList.iterator();

        while (iterator.hasNext()) {
            Contact contact = iterator.next();

            if (contact.getFirstName().equalsIgnoreCase(firstName)) {
                iterator.remove();
                found = true;
                System.out.println("Contact Deleted Successfully!");
                break;
            }
        }
        
        if (!found) {
            System.out.println("Contact not found with name: " + firstName);
        }
	}
	
	public void displayDetails() {
		System.out.println("All Contact Details");
		
		if(contactList.isEmpty()) {
			System.out.println("No Contacts Added");
		}
		
		for(Contact c : contactList) {
			System.out.println(c);
		}
	}
}
