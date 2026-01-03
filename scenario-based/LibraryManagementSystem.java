public class LibraryManagementSystem {
    static Book[] library = {
        new Book("The Great Gatsby", "F. Scott Fitzgerald"),
        new Book("1984", "George Orwell"),
        new Book("The Hobbit", "J.R.R. Tolkien")
    };

    public static void searchByTitle(String query) {
        System.out.println("Searching for: " + query);
        for (Book b : library) {
            if (b.title.toLowerCase().contains(query.toLowerCase())) {
                String status = b.isAvailable ? "Available" : "Checked Out";
                System.out.println("- " + b.title + " by " + b.author + " [" + status + "]");
            }
        }
    }

    public static void checkout(String exactTitle) {
        for (Book b : library) {
            if (b.title.equalsIgnoreCase(exactTitle) && b.isAvailable) {
                b.isAvailable = false;
                System.out.println("Success! You have checked out: " + b.title);
                return;
            }
        }
        System.out.println("Book unavailable or not found.");
    }
}