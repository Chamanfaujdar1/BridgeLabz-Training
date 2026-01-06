import java.util.*;

class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}

class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String title, String author, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void checkout() throws BookNotAvailableException {
        if (!isAvailable) {
            throw new BookNotAvailableException(
                "Book \"" + title + "\" is currently unavailable."
            );
        }
        isAvailable = false;
    }

    public void display() {
        System.out.println(
            "Title : " + title +
            " | Author : " + author +
            " | Status : " + (isAvailable ? "Available" : "Checked Out")
        );
    }
}

class LibraryManager {

    private List<Book> books = new ArrayList<>();

    public void loadBooks(Book[] bookArray) {
        books.addAll(Arrays.asList(bookArray));
    }

    public void searchByTitle(String keyword) {
        System.out.println("\nSearch Results for \"" + keyword + "\":");
        boolean found = false;

        for (Book book : books) {
            if (book.getTitle().toLowerCase()
                    .contains(keyword.toLowerCase())) {
                book.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching books found.");
        }
    }

    public void checkoutBook(String title)
            throws BookNotAvailableException {

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.checkout();
                System.out.println("Book checked out successfully.");
                return;
            }
        }

        System.out.println("Book not found.");
    }

    public void displayAllBooks() {
        System.out.println("\n--- Library Books ---");
        for (Book book : books) {
            book.display();
        }
    }
}

public class LibraryManagementSystem1 {

    public static void main(String[] args) {

        Book[] bookArray = {
            new Book("Java Programming", "James Gosling", true),
            new Book("Clean Code", "Robert Martin", true),
            new Book("Data Structures", "Mark Allen", false)
        };

        LibraryManager library = new LibraryManager();
        library.loadBooks(bookArray);

        library.displayAllBooks();

        library.searchByTitle("code");

        try {
            library.checkoutBook("Clean Code");
            library.checkoutBook("Data Structures");
        } catch (BookNotAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        }

        library.displayAllBooks();
    }
}
