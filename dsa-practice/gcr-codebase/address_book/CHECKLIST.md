# Address Book Project - Requirements Checklist

## ✅ Use Case Implementation Status

### UC1: Welcome Message & Contact Creation
- [x] Display "Welcome to Address Book Program" in AddressBookMain
- [x] Contact class with firstName, lastName fields
- [x] Contact class with address, city, state, zip fields
- [x] Contact class with phoneNumber, email fields
- [x] Program written using IDE (Eclipse/IntelliJ/VS Code)
- [x] Proper class structure and OOP design

### UC2: Add New Contact
- [x] Console input for adding person details
- [x] Input from AddressBookMain class
- [x] Object-Oriented relationship between AddressBook and Contact
- [x] addContact() method in AddressBook class
- [x] User-friendly prompts for each field
- [x] Success confirmation message

### UC3: Edit Existing Contact
- [x] Edit contact using person's name
- [x] Console-based editing
- [x] editContact() method in AddressBook class
- [x] Search by name functionality
- [x] Update all editable fields
- [x] Confirmation messages

### UC4: Delete Contact
- [x] Delete person using person's name
- [x] Console-based deletion
- [x] deleteContact() method in AddressBook class
- [x] Iterator-based safe removal
- [x] Handle "not found" scenario
- [x] Confirmation messages

### UC5: Add Multiple Contacts
- [x] Add multiple persons one at a time
- [x] Console input for each person
- [x] Use ArrayList<Contact> collection
- [x] addMultipleContacts() method
- [x] Loop with exit option
- [x] Maintain multiple contacts in Address Book

### UC6: Multiple Address Books
- [x] AddressBookSystem class created
- [x] Each Address Book has unique name
- [x] Console to add new Address Book
- [x] HashMap<String, AddressBook> for storage
- [x] Prevent duplicate address book names
- [x] Display all address books functionality

### UC7: Duplicate Entry Prevention
- [x] Override equals() method in Contact class
- [x] Override hashCode() method
- [x] Duplicate check on Person Name
- [x] Check while adding person to Address Book
- [x] Use Collection.contains() method
- [x] Display error message for duplicates

### UC8: Search Person by City or State
- [x] Search across multiple Address Books
- [x] searchPersonByCity() method
- [x] searchPersonByState() method
- [x] Show multiple persons in results
- [x] Display which address book contains person
- [x] Handle "not found" scenario

### UC9: View Persons by City or State
- [x] viewPersonsByCity() method
- [x] viewPersonsByState() method
- [x] HashMap<String, List<String>> for City
- [x] HashMap<String, List<String>> for State
- [x] Use Collection Library
- [x] Display grouped results

### UC10: Count Contacts by City or State
- [x] countByCity() method
- [x] countByState() method
- [x] Display count for each city
- [x] Display count for each state
- [x] Use HashMap for counting
- [x] Handle empty scenario

### UC11: Sort Alphabetically by Name
- [x] Implement Comparable<Contact> interface
- [x] Override compareTo() method
- [x] Sort by Person's full name
- [x] Override toString() method
- [x] Use Collections.sort()
- [x] Console display of sorted list
- [x] Case-insensitive sorting

### UC12: Sort by City, State, or Zip
- [x] sortByCity() method
- [x] sortByState() method
- [x] sortByZip() method
- [x] Use Comparator with lambda expressions
- [x] Use Collection Library for sorting
- [x] Case-insensitive sorting for city/state

### UC13: File I/O Operations
- [x] FileIOService class created
- [x] writeToFile() method using File IO
- [x] readFromFile() method using File IO
- [x] BufferedWriter for writing
- [x] BufferedReader for reading
- [x] Error handling with try-catch

### UC14: CSV File Operations
- [x] CSVService class created
- [x] writeToCSV() method
- [x] readFromCSV() method
- [x] Proper CSV format with delimiter
- [x] Header row support
- [x] Parse CSV data correctly

### UC15: JSON File Operations
- [x] JSONService class created
- [x] writeToJSON() method
- [x] readFromJSON() method
- [x] Proper JSON structure
- [x] Array format with objects
- [x] Proper indentation

### UC16: JSONServer Integration ⏳
- [ ] REST API integration
- [ ] Use RESTAssured.NET library
- [ ] GET, POST, PUT, DELETE operations
- [ ] Server communication
- [ ] Error handling for network operations

### UC17: Async I/O Operations ⏳
- [ ] Non-blocking file operations
- [ ] Thread-based implementation
- [ ] Prevent main thread blocking
- [ ] Async for CSV operations
- [ ] Async for JSON operations
- [ ] Async for JSONServer operations

### UC18: Database Integration ⏳
- [ ] Database connectivity
- [ ] Save AddressBook to Database
- [ ] Open-Close Principle compliance
- [ ] Support for existing data sources (CSV, JSON, JSONServer)
- [ ] No violation when adding new data source
- [ ] SQL operations (CRUD)

## 📋 Code Quality Checklist

### Naming Conventions
- [x] Class names in PascalCase (Contact, AddressBook)
- [x] Method names in camelCase (addContact, editContact)
- [x] Variable names in camelCase (firstName, lastName)
- [x] Constants in UPPER_SNAKE_CASE (FILE_NAME, CSV_FILE)
- [x] Meaningful and descriptive names

### Indentation & Formatting
- [x] Consistent indentation (tabs or spaces)
- [x] Proper spacing around operators
- [x] Proper bracing style
- [x] Line length within reasonable limits
- [x] Organized imports

### Code Hygiene
- [x] No unused variables
- [x] No unused imports
- [x] No code duplication
- [x] Proper error handling
- [x] Comments for complex logic
- [x] No magic numbers
- [x] Single Responsibility Principle

### Object-Oriented Design
- [x] Proper encapsulation (private fields, public methods)
- [x] Appropriate use of classes and objects
- [x] Interface implementation where needed
- [x] Method overriding where appropriate
- [x] Proper inheritance relationships
- [x] Separation of concerns

## 🔧 Git Requirements Checklist

### Branch Management
- [ ] UC1 in separate branch (uc1-welcome-message)
- [ ] UC2 in separate branch (uc2-add-contact)
- [ ] UC3 in separate branch (uc3-edit-contact)
- [ ] UC4 in separate branch (uc4-delete-contact)
- [ ] UC5 in separate branch (uc5-multiple-contacts)
- [ ] UC6 in separate branch (uc6-multiple-addressbooks)
- [ ] UC7 in separate branch (uc7-duplicate-check)
- [ ] UC8 in separate branch (uc8-search-city-state)
- [ ] UC9 in separate branch (uc9-view-by-location)
- [ ] UC10 in separate branch (uc10-count-contacts)
- [ ] UC11 in separate branch (uc11-sort-by-name)
- [ ] UC12 in separate branch (uc12-sort-by-location)
- [ ] UC13 in separate branch (uc13-file-io)
- [ ] UC14 in separate branch (uc14-csv-operations)
- [ ] UC15 in separate branch (uc15-json-operations)

### Git Commits
- [ ] Each UC merged to master branch
- [ ] Meaningful commit messages
- [ ] Format: "UC#: Description"
- [ ] Regular commits for each feature
- [ ] No large monolithic commits

### Version History
- [ ] Clean commit history
- [ ] Proper branch merging
- [ ] No merge conflicts
- [ ] Tags for major milestones
- [ ] README updated with each UC

## 📁 File Structure Checklist

### Core Java Files
- [x] AddressBookMain.java (Main entry point)
- [x] Contact.java (Contact entity)
- [x] AddressBook.java (Single address book)
- [x] AddressBookSystem.java (Multiple address books)
- [x] FileIOService.java (Text file I/O)
- [x] CSVService.java (CSV operations)
- [x] JSONService.java (JSON operations)

### Documentation Files
- [x] README.md (Project documentation)
- [x] GIT_WORKFLOW.md (Git commands and workflow)
- [x] TEST_DATA.md (Sample test data)
- [x] PROJECT_SUMMARY.md (Implementation summary)
- [x] QUICK_START.md (Quick start guide)
- [x] CHECKLIST.md (This file)

### Generated Files (Runtime)
- [ ] AddressBook.txt (Text file output)
- [ ] AddressBook.csv (CSV file output)
- [ ] AddressBook.json (JSON file output)

## 🧪 Testing Checklist

### Functional Testing
- [ ] Test UC1: Welcome message displays
- [ ] Test UC2: Add single contact
- [ ] Test UC3: Edit existing contact
- [ ] Test UC4: Delete contact
- [ ] Test UC5: Add multiple contacts
- [ ] Test UC6: Create multiple address books
- [ ] Test UC7: Duplicate prevention works
- [ ] Test UC8: Search by city and state
- [ ] Test UC9: View grouped by city and state
- [ ] Test UC10: Count by city and state
- [ ] Test UC11: Sort by name works
- [ ] Test UC12: Sort by city, state, zip works
- [ ] Test UC13: File I/O operations work
- [ ] Test UC14: CSV operations work
- [ ] Test UC15: JSON operations work

### Edge Cases Testing
- [ ] Empty address book operations
- [ ] Invalid input handling
- [ ] Non-existent contact operations
- [ ] File not found scenarios
- [ ] Duplicate name handling
- [ ] Case sensitivity testing
- [ ] Special characters in names
- [ ] Very long input strings

### Integration Testing
- [ ] Multiple address books with same contacts
- [ ] Search across empty address books
- [ ] Sort empty contact list
- [ ] File operations with no contacts
- [ ] Multiple file format operations

## 📊 Project Statistics

- **Total Use Cases:** 18
- **Completed:** 15 (83%)
- **Pending:** 3 (17%)
- **Total Classes:** 7
- **Total Methods:** 40+
- **Lines of Code:** 800+
- **Documentation Files:** 6

## 🎯 Next Steps

1. ✅ Complete UC1-UC15 implementation
2. ✅ Create comprehensive documentation
3. ⏳ Set up Git branches for each UC
4. ⏳ Commit and merge each UC separately
5. ⏳ Implement UC16: JSONServer
6. ⏳ Implement UC17: Async I/O
7. ⏳ Implement UC18: Database Integration
8. ⏳ Final testing and bug fixes
9. ⏳ Code review and refactoring
10. ⏳ Final submission

## ✨ Completion Status

**Current Status:** 15/18 Use Cases Completed (83%)

**Ready for:**
- ✅ Code review
- ✅ Functional testing
- ✅ Git branch setup
- ⏳ Advanced features (UC16-18)

---

**Last Updated:** January 2025
**Student ID:** 2215000509
**Program:** BridgeLabz Training
