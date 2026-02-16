# Quick Start Guide - Address Book Program

## 🚀 Getting Started in 3 Steps

### Step 1: Compile the Program
```bash
cd d:\BridgeLabz-Training\dsa-practice\gcr-codebase\address_book
javac *.java
```

### Step 2: Run the Program
```bash
java AddressBookMain
```

### Step 3: Follow the Menu
You'll see:
```
Welcome to Address Book Program

========== Address Book System Menu ==========
1. Create New Address Book
2. Select Address Book & Manage Contacts
3. Display All Address Books
...
```

## 📋 Common Workflows

### Workflow 1: Create Your First Address Book
1. Choose option `1` - Create New Address Book
2. Enter name: `Personal`
3. Choose option `2` - Select Address Book & Manage Contacts
4. Enter name: `Personal`
5. Now you're in the Address Book menu!

### Workflow 2: Add Your First Contact
1. From Address Book menu, choose `1` - Add Contact
2. Enter details:
   - First Name: John
   - Last Name: Doe
   - Address: 123 Main Street
   - City: Mumbai
   - State: Maharashtra
   - Zip: 400001
   - Phone: 9876543210
   - Email: john.doe@email.com
3. See success message!

### Workflow 3: Add Multiple Contacts Quickly
1. Choose option `2` - Add Multiple Contacts
2. Enter first contact details
3. When asked "Do you want to add another contact?", type `yes`
4. Continue adding contacts
5. Type `no` when done

### Workflow 4: View All Contacts
1. Choose option `5` - Display All Contacts
2. See all your contacts listed

### Workflow 5: Edit a Contact
1. Choose option `3` - Edit Contact
2. Enter first name of person to edit
3. Enter new details for each field
4. See update confirmation

### Workflow 6: Delete a Contact
1. Choose option `4` - Delete Contact
2. Enter first name of person to delete
3. See deletion confirmation

### Workflow 7: Sort Contacts
1. Choose option `6` - Sort by Name (alphabetically)
2. Or choose `7` - Sort by City
3. Or choose `8` - Sort by State
4. Or choose `9` - Sort by Zip
5. Sorted list will be displayed

### Workflow 8: Save to File
1. Choose option `10` - Save to Text File
2. Or choose `12` - Save to CSV File
3. Or choose `14` - Save to JSON File
4. File will be created in the same directory

### Workflow 9: Read from File
1. Choose option `11` - Read from Text File
2. Or choose `13` - Read from CSV File
3. Or choose `15` - Read from JSON File
4. Contents will be displayed

### Workflow 10: Search Across All Address Books
1. Go back to main menu (option `16`)
2. Choose option `4` - Search by City
3. Enter city name (e.g., Mumbai)
4. See all persons in that city across all address books

### Workflow 11: View Statistics
1. From main menu, choose option `8` - Count by City
2. Or choose option `9` - Count by State
3. See how many contacts in each location

## 🎯 Quick Tips

### Tip 1: Duplicate Prevention
- If you try to add a contact with the same first and last name, you'll get an error
- This prevents duplicate entries

### Tip 2: Case Insensitive
- Searching and sorting are case-insensitive
- "Mumbai" and "mumbai" are treated the same

### Tip 3: Multiple Address Books
- You can create separate address books for different purposes
- Example: "Personal", "Work", "Family", "Friends"

### Tip 4: File Formats
- Text File: Simple line-by-line format
- CSV File: Can be opened in Excel
- JSON File: Structured format for data exchange

### Tip 5: Navigation
- Always read the menu options carefully
- Use option `12` or `16` to go back to previous menu
- Use option `10` to exit the program

## 🐛 Troubleshooting

### Problem: "Contact not found"
**Solution:** Check the spelling of the first name. It must match exactly.

### Problem: "Address Book not found"
**Solution:** Make sure you created the address book first using option 1.

### Problem: "Duplicate Entry"
**Solution:** A contact with that name already exists. Use edit instead.

### Problem: "Error reading file"
**Solution:** Make sure the file exists. Save contacts first before reading.

### Problem: "Invalid choice"
**Solution:** Enter only the numbers shown in the menu.

## 📝 Sample Test Run

```
Welcome to Address Book Program

========== Address Book System Menu ==========
1. Create New Address Book
...
Enter your choice: 1

Create New Address Book
Enter Address Book Name: Personal
Address Book 'Personal' created successfully!

Enter your choice: 2

Enter Address Book Name: Personal

========== Address Book Menu ==========
1. Add Contact
...
Enter your choice: 1

Add new Contact
Enter First Name: John
Enter Last Name: Doe
Enter address: 123 Main Street
Enter City: Mumbai
Enter State: Maharashtra
Enter Zip: 400001
Enter Phone Number: 9876543210
Enter Email: john.doe@email.com
Contacts added successfully

Enter your choice: 5

All Contact Details
Contact Details {First Name='John', Last Name='Doe', Address='123 Main Street', City='Mumbai', State='Maharashtra', Zip='400001', Phone Number='9876543210', Email='john.doe@email.com'}
```

## 📚 Next Steps

1. ✅ Complete UC1-UC15 (Already Done!)
2. ⏳ Implement UC16: JSONServer Integration
3. ⏳ Implement UC17: Async I/O Operations
4. ⏳ Implement UC18: Database Integration

## 📖 More Information

- See **README.md** for complete documentation
- See **GIT_WORKFLOW.md** for Git commands
- See **TEST_DATA.md** for sample test data
- See **PROJECT_SUMMARY.md** for implementation details

## 🎓 Learning Resources

- Java Collections: ArrayList, HashMap
- File I/O: BufferedReader, BufferedWriter
- OOP Concepts: Classes, Objects, Interfaces
- Sorting: Comparable, Comparator
- Exception Handling: try-catch blocks

---

**Happy Coding! 🚀**

For questions or issues, refer to the documentation files or contact your instructor.
