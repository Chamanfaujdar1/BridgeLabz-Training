# Sample Test Data for Address Book

## Test Contact 1
First Name: John
Last Name: Doe
Address: 123 Main Street
City: Mumbai
State: Maharashtra
Zip: 400001
Phone: 9876543210
Email: john.doe@email.com

## Test Contact 2
First Name: Jane
Last Name: Smith
Address: 456 Park Avenue
City: Mumbai
State: Maharashtra
Zip: 400002
Phone: 9876543211
Email: jane.smith@email.com

## Test Contact 3
First Name: Bob
Last Name: Johnson
Address: 789 Oak Road
City: Delhi
State: Delhi
Zip: 110001
Phone: 9876543212
Email: bob.johnson@email.com

## Test Contact 4
First Name: Alice
Last Name: Williams
Address: 321 Pine Street
City: Bangalore
State: Karnataka
Zip: 560001
Phone: 9876543213
Email: alice.williams@email.com

## Test Contact 5
First Name: Charlie
Last Name: Brown
Address: 654 Elm Avenue
City: Delhi
State: Delhi
Zip: 110002
Phone: 9876543214
Email: charlie.brown@email.com

## Test Scenarios

### UC1: Welcome Message
- Run the program and verify welcome message displays

### UC2: Add Contact
- Add Test Contact 1
- Verify success message

### UC3: Edit Contact
- Edit John's phone number to 9999999999
- Verify update confirmation

### UC4: Delete Contact
- Delete Bob Johnson
- Verify deletion confirmation

### UC5: Add Multiple Contacts
- Add Test Contacts 2, 3, 4, 5 in sequence
- Verify all added successfully

### UC6: Multiple Address Books
- Create "Personal" address book
- Create "Work" address book
- Add contacts to each

### UC7: Duplicate Check
- Try adding John Doe again
- Verify duplicate error message

### UC8: Search by City/State
- Search for persons in "Mumbai"
- Search for persons in "Delhi"
- Verify multiple results shown

### UC9: View by City/State
- View all persons grouped by city
- View all persons grouped by state

### UC10: Count by City/State
- Count persons in Mumbai (should be 2)
- Count persons in Delhi (should be 2)

### UC11: Sort by Name
- Add all test contacts
- Sort alphabetically
- Verify order: Alice, Bob, Charlie, Jane, John

### UC12: Sort by City/State/Zip
- Sort by City: Bangalore, Delhi, Mumbai
- Sort by State: Delhi, Karnataka, Maharashtra
- Sort by Zip: 110001, 110002, 400001, 400002, 560001

### UC13: File I/O
- Add contacts
- Save to file
- Read from file
- Verify data matches

### UC14: CSV Operations
- Save contacts to CSV
- Open CSV file and verify format
- Read from CSV

### UC15: JSON Operations
- Save contacts to JSON
- Open JSON file and verify structure
- Read from JSON
