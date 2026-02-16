# Address Book System - Architecture Diagram

## System Architecture

```
┌─────────────────────────────────────────────────────────────────┐
│                     AddressBookMain.java                        │
│                    (Main Entry Point)                           │
│  - main() method                                                │
│  - manageAddressBook() method                                   │
│  - Console-based menu system                                    │
└────────────────────────┬────────────────────────────────────────┘
                         │
                         │ creates & manages
                         ▼
┌─────────────────────────────────────────────────────────────────┐
│                  AddressBookSystem.java                         │
│              (Multiple Address Books Manager)                   │
│  - HashMap<String, AddressBook> addressBookMap                  │
│  - addNewAddressBook()                                          │
│  - getAddressBook()                                             │
│  - searchPersonByCity()                                         │
│  - searchPersonByState()                                        │
│  - viewPersonsByCity()                                          │
│  - viewPersonsByState()                                         │
│  - countByCity()                                                │
│  - countByState()                                               │
└────────────────────────┬────────────────────────────────────────┘
                         │
                         │ contains multiple
                         ▼
┌─────────────────────────────────────────────────────────────────┐
│                    AddressBook.java                             │
│                (Single Address Book Manager)                    │
│  - ArrayList<Contact> contactList                               │
│  - addContact()                    [UC2]                        │
│  - addMultipleContacts()           [UC5]                        │
│  - editContact()                   [UC3]                        │
│  - deleteContact()                 [UC4]                        │
│  - displayDetails()                                             │
│  - sortContactsByName()            [UC11]                       │
│  - sortByCity()                    [UC12]                       │
│  - sortByState()                   [UC12]                       │
│  - sortByZip()                     [UC12]                       │
└────────────────────────┬────────────────────────────────────────┘
                         │
                         │ contains multiple
                         ▼
┌─────────────────────────────────────────────────────────────────┐
│                      Contact.java                               │
│                   (Contact Entity)                              │
│  - String firstName, lastName                                   │
│  - String address, city, state, zip                             │
│  - String phoneNumber, email                                    │
│  - Getters and Setters                                          │
│  - equals() & hashCode()           [UC7]                        │
│  - compareTo()                     [UC11]                       │
│  - toString()                                                   │
│  - implements Comparable<Contact>                               │
└─────────────────────────────────────────────────────────────────┘
```

## File I/O Services

```
┌─────────────────────────────────────────────────────────────────┐
│                   File I/O Services Layer                       │
├─────────────────────────────────────────────────────────────────┤
│                                                                 │
│  ┌──────────────────────┐  ┌──────────────────────┐           │
│  │  FileIOService.java  │  │   CSVService.java    │           │
│  │      [UC13]          │  │      [UC14]          │           │
│  ├──────────────────────┤  ├──────────────────────┤           │
│  │ - writeToFile()      │  │ - writeToCSV()       │           │
│  │ - readFromFile()     │  │ - readFromCSV()      │           │
│  │                      │  │                      │           │
│  │ Uses:                │  │ Uses:                │           │
│  │ - BufferedWriter     │  │ - BufferedWriter     │           │
│  │ - BufferedReader     │  │ - BufferedReader     │           │
│  │                      │  │ - CSV Format         │           │
│  │ Output:              │  │                      │           │
│  │ AddressBook.txt      │  │ Output:              │           │
│  └──────────────────────┘  │ AddressBook.csv      │           │
│                            └──────────────────────┘           │
│                                                                 │
│  ┌──────────────────────┐                                      │
│  │  JSONService.java    │                                      │
│  │      [UC15]          │                                      │
│  ├──────────────────────┤                                      │
│  │ - writeToJSON()      │                                      │
│  │ - readFromJSON()     │                                      │
│  │                      │                                      │
│  │ Uses:                │                                      │
│  │ - BufferedWriter     │                                      │
│  │ - BufferedReader     │                                      │
│  │ - JSON Format        │                                      │
│  │                      │                                      │
│  │ Output:              │                                      │
│  │ AddressBook.json     │                                      │
│  └──────────────────────┘                                      │
│                                                                 │
└─────────────────────────────────────────────────────────────────┘
```

## Data Flow Diagram

```
┌──────────┐
│   User   │
└────┬─────┘
     │
     │ Input via Console
     ▼
┌─────────────────────┐
│ AddressBookMain     │
│ (Menu System)       │
└────┬────────────────┘
     │
     ├─────────────────────────────────────────┐
     │                                         │
     ▼                                         ▼
┌─────────────────────┐              ┌─────────────────────┐
│ AddressBookSystem   │              │ File I/O Services   │
│ (UC6, UC8-UC10)     │              │ (UC13-UC15)         │
└────┬────────────────┘              └─────────────────────┘
     │                                         │
     │ manages                                 │
     ▼                                         │
┌─────────────────────┐                       │
│ AddressBook         │◄──────────────────────┘
│ (UC2-UC5, UC11-12)  │     reads/writes
└────┬────────────────┘
     │
     │ contains
     ▼
┌─────────────────────┐
│ Contact             │
│ (UC1, UC7)          │
└─────────────────────┘
```

## Class Relationships

```
┌─────────────────────────────────────────────────────────────────┐
│                    Class Relationships                          │
└─────────────────────────────────────────────────────────────────┘

AddressBookMain
    │
    ├── uses ──► AddressBookSystem
    │                │
    │                └── contains ──► HashMap<String, AddressBook>
    │                                        │
    │                                        └── value ──► AddressBook
    │
    └── uses ──► AddressBook
                    │
                    └── contains ──► ArrayList<Contact>
                                            │
                                            └── element ──► Contact
                                                              │
                                                              └── implements ──► Comparable<Contact>

FileIOService ──► reads/writes ──► ArrayList<Contact>
CSVService ──► reads/writes ──► ArrayList<Contact>
JSONService ──► reads/writes ──► ArrayList<Contact>
```

## Use Case Mapping

```
┌─────────────────────────────────────────────────────────────────┐
│                    Use Case to Class Mapping                    │
├─────────────────────────────────────────────────────────────────┤
│                                                                 │
│  UC1  : Contact.java + AddressBookMain.java                    │
│  UC2  : AddressBook.addContact()                               │
│  UC3  : AddressBook.editContact()                              │
│  UC4  : AddressBook.deleteContact()                            │
│  UC5  : AddressBook.addMultipleContacts()                      │
│  UC6  : AddressBookSystem (entire class)                       │
│  UC7  : Contact.equals() + Contact.hashCode()                  │
│  UC8  : AddressBookSystem.searchPersonByCity/State()           │
│  UC9  : AddressBookSystem.viewPersonsByCity/State()            │
│  UC10 : AddressBookSystem.countByCity/State()                  │
│  UC11 : Contact.compareTo() + AddressBook.sortContactsByName() │
│  UC12 : AddressBook.sortByCity/State/Zip()                     │
│  UC13 : FileIOService (entire class)                           │
│  UC14 : CSVService (entire class)                              │
│  UC15 : JSONService (entire class)                             │
│                                                                 │
└─────────────────────────────────────────────────────────────────┘
```

## Menu Structure

```
Main Menu (AddressBookMain)
│
├── 1. Create New Address Book [UC6]
│
├── 2. Select Address Book & Manage Contacts
│   │
│   └── Address Book Menu
│       │
│       ├── 1. Add Contact [UC2]
│       ├── 2. Add Multiple Contacts [UC5]
│       ├── 3. Edit Contact [UC3]
│       ├── 4. Delete Contact [UC4]
│       ├── 5. Display All Contacts
│       ├── 6. Sort by Name [UC11]
│       ├── 7. Sort by City [UC12]
│       ├── 8. Sort by State [UC12]
│       ├── 9. Sort by Zip [UC12]
│       ├── 10. Save to Text File [UC13]
│       ├── 11. Read from Text File [UC13]
│       ├── 12. Save to CSV [UC14]
│       ├── 13. Read from CSV [UC14]
│       ├── 14. Save to JSON [UC15]
│       ├── 15. Read from JSON [UC15]
│       └── 16. Back to Main Menu
│
├── 3. Display All Address Books [UC6]
├── 4. Search by City [UC8]
├── 5. Search by State [UC8]
├── 6. View by City [UC9]
├── 7. View by State [UC9]
├── 8. Count by City [UC10]
├── 9. Count by State [UC10]
└── 10. Exit
```

## Data Structures Used

```
┌─────────────────────────────────────────────────────────────────┐
│                    Data Structures                              │
├─────────────────────────────────────────────────────────────────┤
│                                                                 │
│  ArrayList<Contact>                                             │
│  └── Used in: AddressBook.contactList                          │
│      Purpose: Store multiple contacts in a single address book │
│                                                                 │
│  HashMap<String, AddressBook>                                   │
│  └── Used in: AddressBookSystem.addressBookMap                 │
│      Purpose: Store multiple address books with unique names   │
│                                                                 │
│  HashMap<String, List<String>>                                  │
│  └── Used in: viewPersonsByCity(), viewPersonsByState()        │
│      Purpose: Group persons by city or state                   │
│                                                                 │
│  HashMap<String, Integer>                                       │
│  └── Used in: countByCity(), countByState()                    │
│      Purpose: Count persons in each city or state              │
│                                                                 │
└─────────────────────────────────────────────────────────────────┘
```

## File Format Examples

### Text File (AddressBook.txt)
```
Contact Details {First Name='John', Last Name='Doe', ...}
Contact Details {First Name='Jane', Last Name='Smith', ...}
```

### CSV File (AddressBook.csv)
```
FirstName,LastName,Address,City,State,Zip,PhoneNumber,Email
John,Doe,123 Main St,Mumbai,Maharashtra,400001,9876543210,john@email.com
Jane,Smith,456 Park Ave,Delhi,Delhi,110001,9876543211,jane@email.com
```

### JSON File (AddressBook.json)
```json
[
  {
    "firstName": "John",
    "lastName": "Doe",
    "address": "123 Main St",
    "city": "Mumbai",
    "state": "Maharashtra",
    "zip": "400001",
    "phoneNumber": "9876543210",
    "email": "john@email.com"
  }
]
```

---

**Architecture Type:** Layered Architecture
**Design Pattern:** MVC-like (Model: Contact, Controller: AddressBook/System, View: Console)
**Data Access:** File-based (Text, CSV, JSON)
