# Address Book Program

## Overview
A comprehensive Address Book Management System built in Java that allows users to manage multiple address books with contacts, search functionality, sorting capabilities, and file I/O operations.

## Features Implemented

### UC1: Display Welcome Message & Create Contact
- Welcome message displayed in AddressBookMain class
- Contact class with first name, last name, address, city, state, zip, phone number, and email
- Object-oriented design with proper encapsulation

### UC2: Add New Contact
- Console-based input for adding new contacts
- Object-oriented relationship between AddressBook and Contact
- Input validation and user-friendly prompts

### UC3: Edit Existing Contact
- Edit contact details using person's name
- Update address, city, state, zip, phone number, and email
- Confirmation messages for successful updates

### UC4: Delete Contact
- Delete person using their name
- Iterator-based safe removal from collection
- Confirmation messages

### UC5: Add Multiple Contacts
- Add multiple persons one at a time
- Uses ArrayList to maintain multiple contacts
- Loop-based input with exit option

### UC6: Multiple Address Books
- System supports multiple address books
- Each address book has a unique name
- Dictionary/HashMap to maintain address book collection
- Prevents duplicate address book names

### UC7: Duplicate Entry Prevention
- Override equals() method in Contact class
- Duplicate check based on person's name
- Uses Collection methods for duplicate detection
- Prevents adding same person twice

### UC8: Search Person by City or State
- Search across multiple address books
- Find persons in a specific city or state
- Display multiple matching results

### UC9: View Persons by City or State
- Dictionary/HashMap to group persons by city
- Dictionary/HashMap to group persons by state
- Display organized view of contacts

### UC10: Count Contacts by City or State
- Count number of persons in each city
- Count number of persons in each state
- Display statistics

### UC11: Sort Contacts Alphabetically
- Implement Comparable interface in Contact class
- Sort by person's full name (first + last)
- Override toString() method for display
- Uses Collections.sort()

### UC12: Sort by City, State, or Zip
- Separate methods for each sorting criteria
- Uses Comparator with lambda expressions
- Case-insensitive sorting

### UC13: File I/O Operations
- Read and write contacts to text file
- BufferedReader and BufferedWriter
- Error handling for file operations

### UC14: CSV File Operations
- Write contacts to CSV format
- Read contacts from CSV file
- Proper delimiter handling
- Header row support

### UC15: JSON File Operations
- Write contacts to JSON format
- Read contacts from JSON file
- Proper JSON structure formatting

## Project Structure

```
address_book/
├── AddressBookMain.java       # Main entry point with menu system
├── Contact.java               # Contact entity class
├── AddressBook.java           # Single address book management
├── AddressBookSystem.java     # Multiple address books system
├── FileIOService.java         # Text file I/O operations
├── CSVService.java            # CSV file operations
└── JSONService.java           # JSON file operations
```

## Class Descriptions

### Contact.java
- Represents a single contact with all personal details
- Implements Comparable for sorting by name
- Overrides equals() and hashCode() for duplicate detection
- Provides getters and setters for all fields

### AddressBook.java
- Manages a collection of contacts
- Provides CRUD operations (Create, Read, Update, Delete)
- Implements sorting functionality
- Duplicate prevention using equals()

### AddressBookSystem.java
- Manages multiple address books
- Search functionality across all books
- View and count operations by city/state
- Uses HashMap for efficient lookup

### FileIOService.java
- Text file read/write operations
- Simple line-based storage

### CSVService.java
- CSV format read/write operations
- Comma-separated values with header

### JSONService.java
- JSON format read/write operations
- Structured JSON array format

## How to Run

1. Compile all Java files:
```bash
javac *.java
```

2. Run the main program:
```bash
java AddressBookMain
```

3. Follow the menu prompts to:
   - Create address books
   - Add/Edit/Delete contacts
   - Search and view contacts
   - Sort contacts
   - Save/Load from files

## Git Workflow

- Each Use Case is developed in a separate branch
- Branch naming: `uc1-welcome-message`, `uc2-add-contact`, etc.
- Merged to master after completion
- Proper commit messages for version history

## Code Quality

- Follows Java naming conventions
- Proper indentation and formatting
- Meaningful variable and method names
- Comments for complex logic
- Error handling for user inputs
- Modular and maintainable code

## Future Enhancements (UC16-UC18)

- UC16: JSONServer integration with REST API
- UC17: Async I/O operations (non-blocking)
- UC18: Database integration with Open-Close Principle

## Author
BridgeLabz Training Program - 2215000509

## Repository
https://github.com/Chamanfaujdar1/BridgeLabz-Training
