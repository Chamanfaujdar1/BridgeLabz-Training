# Git Workflow Guide for Address Book Project

## Branch Strategy

Each Use Case (UC) should be developed in a separate branch and then merged to master.

## Step-by-Step Git Commands

### Initial Setup (Already Done)
```bash
# Initialize repository
git init

# Add remote repository
git remote add origin https://github.com/Chamanfaujdar1/BridgeLabz-Training.git

# Check current branch
git branch
```

### UC1: Welcome Message & Contact Creation
```bash
# Create and switch to UC1 branch
git checkout -b uc1-welcome-message

# Make changes to files
# Add files
git add .

# Commit with meaningful message
git commit -m "UC1: Added welcome message and Contact class with all fields"

# Switch back to master
git checkout master

# Merge UC1 to master
git merge uc1-welcome-message

# Push to remote
git push origin master
```

### UC2: Add New Contact
```bash
git checkout -b uc2-add-contact
# Make changes
git add .
git commit -m "UC2: Implemented add contact functionality with console input"
git checkout master
git merge uc2-add-contact
git push origin master
```

### UC3: Edit Contact
```bash
git checkout -b uc3-edit-contact
# Make changes
git add .
git commit -m "UC3: Added edit contact feature using person name"
git checkout master
git merge uc3-edit-contact
git push origin master
```

### UC4: Delete Contact
```bash
git checkout -b uc4-delete-contact
# Make changes
git add .
git commit -m "UC4: Implemented delete contact functionality"
git checkout master
git merge uc4-delete-contact
git push origin master
```

### UC5: Add Multiple Contacts
```bash
git checkout -b uc5-multiple-contacts
# Make changes
git add .
git commit -m "UC5: Added functionality to add multiple contacts using ArrayList"
git checkout master
git merge uc5-multiple-contacts
git push origin master
```

### UC6: Multiple Address Books
```bash
git checkout -b uc6-multiple-addressbooks
# Make changes
git add .
git commit -m "UC6: Implemented AddressBookSystem with HashMap for multiple address books"
git checkout master
git merge uc6-multiple-addressbooks
git push origin master
```

### UC7: Duplicate Prevention
```bash
git checkout -b uc7-duplicate-check
# Make changes
git add .
git commit -m "UC7: Override equals method and added duplicate entry prevention"
git checkout master
git merge uc7-duplicate-check
git push origin master
```

### UC8: Search by City or State
```bash
git checkout -b uc8-search-city-state
# Make changes
git add .
git commit -m "UC8: Added search functionality across multiple address books by city and state"
git checkout master
git merge uc8-search-city-state
git push origin master
```

### UC9: View by City or State
```bash
git checkout -b uc9-view-by-location
# Make changes
git add .
git commit -m "UC9: Implemented view persons grouped by city and state using HashMap"
git checkout master
git merge uc9-view-by-location
git push origin master
```

### UC10: Count by City or State
```bash
git checkout -b uc10-count-contacts
# Make changes
git add .
git commit -m "UC10: Added count functionality for contacts by city and state"
git checkout master
git merge uc10-count-contacts
git push origin master
```

### UC11: Sort Alphabetically
```bash
git checkout -b uc11-sort-by-name
# Make changes
git add .
git commit -m "UC11: Implemented Comparable interface and sort by name with toString override"
git checkout master
git merge uc11-sort-by-name
git push origin master
```

### UC12: Sort by City, State, Zip
```bash
git checkout -b uc12-sort-by-location
# Make changes
git add .
git commit -m "UC12: Added sorting functionality by city, state, and zip using Comparator"
git checkout master
git merge uc12-sort-by-location
git push origin master
```

### UC13: File I/O Operations
```bash
git checkout -b uc13-file-io
# Make changes
git add .
git commit -m "UC13: Implemented read/write operations using File IO"
git checkout master
git merge uc13-file-io
git push origin master
```

### UC14: CSV File Operations
```bash
git checkout -b uc14-csv-operations
# Make changes
git add .
git commit -m "UC14: Added CSV read/write functionality"
git checkout master
git merge uc14-csv-operations
git push origin master
```

### UC15: JSON File Operations
```bash
git checkout -b uc15-json-operations
# Make changes
git add .
git commit -m "UC15: Implemented JSON read/write operations"
git checkout master
git merge uc15-json-operations
git push origin master
```

## Useful Git Commands

### Check Status
```bash
git status
```

### View Commit History
```bash
git log --oneline
git log --graph --oneline --all
```

### View Branches
```bash
git branch -a
```

### Delete Branch (After Merge)
```bash
git branch -d uc1-welcome-message
```

### Undo Changes (Before Commit)
```bash
git checkout -- filename
```

### View Differences
```bash
git diff
git diff filename
```

### Push All Branches
```bash
git push --all origin
```

## Best Practices

1. **Commit Messages**: Use clear, descriptive commit messages
   - Format: "UC#: Brief description of changes"
   - Example: "UC7: Override equals method and added duplicate entry prevention"

2. **Branch Naming**: Use descriptive branch names
   - Format: `uc#-feature-name`
   - Example: `uc6-multiple-addressbooks`

3. **Frequent Commits**: Commit logical units of work

4. **Test Before Merge**: Always test functionality before merging to master

5. **Clean History**: Delete branches after successful merge

6. **Pull Before Push**: Always pull latest changes before pushing
   ```bash
   git pull origin master
   git push origin master
   ```

## Current Project Status

✅ UC1: Welcome Message & Contact Creation
✅ UC2: Add New Contact
✅ UC3: Edit Contact
✅ UC4: Delete Contact
✅ UC5: Add Multiple Contacts
✅ UC6: Multiple Address Books
✅ UC7: Duplicate Prevention
✅ UC8: Search by City/State
✅ UC9: View by City/State
✅ UC10: Count by City/State
✅ UC11: Sort Alphabetically
✅ UC12: Sort by City/State/Zip
✅ UC13: File I/O
✅ UC14: CSV Operations
✅ UC15: JSON Operations
⏳ UC16: JSONServer (Pending)
⏳ UC17: Async I/O (Pending)
⏳ UC18: Database Integration (Pending)
