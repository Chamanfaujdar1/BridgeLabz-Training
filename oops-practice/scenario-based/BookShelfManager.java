import java.util.*;

class Book {
    private String bookId;
    private String title;
    private String author;
    private String genre;

    Book(String bookId, String title, String author, String genre) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public String getBookId() {
        return bookId;
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "[ID=" + bookId + ", Title=" + title + ", Author=" + author + ", Genre=" + genre + "]";
    }
}

class LibraryCatalog {

    private HashMap<String, LinkedList<Book>> genreMap;

    private HashSet<String> bookIdSet;

    LibraryCatalog() {
        genreMap = new HashMap<>();
        bookIdSet = new HashSet<>();
    }

    public void addBook(Book book) {
        if (bookIdSet.contains(book.getBookId())) {
            System.out.println(" Duplicate Book! Book with ID " + book.getBookId() + " already exists.");
            return;
        }

        genreMap.putIfAbsent(book.getGenre(), new LinkedList<>());
        genreMap.get(book.getGenre()).add(book);

        bookIdSet.add(book.getBookId());

        System.out.println(" Book added successfully: " + book);
    }

    public void borrowBook(String bookId) {
        if (!bookIdSet.contains(bookId)) {
            System.out.println(" Book not found in library!");
            return;
        }

        for (Map.Entry<String, LinkedList<Book>> entry : genreMap.entrySet()) {
            LinkedList<Book> list = entry.getValue();
            Iterator<Book> it = list.iterator();

            while (it.hasNext()) {
                Book b = it.next();
                if (b.getBookId().equalsIgnoreCase(bookId)) {
                    it.remove();
                    bookIdSet.remove(bookId);

                    System.out.println(" Book borrowed successfully: " + b);

                    if (list.isEmpty()) {
                        genreMap.remove(entry.getKey());
                    }
                    return;
                }
            }
        }
    }

    public void printCatalog() {
        if (genreMap.isEmpty()) {
            System.out.println(" Library Catalog is EMPTY!");
            return;
        }

        System.out.println("\n=== Genre-wise Library Catalog ===");
        for (String genre : genreMap.keySet()) {
            System.out.println("Genre: " + genre);
            LinkedList<Book> books = genreMap.get(genre);

            for (Book b : books) {
                System.out.println("   " + b);
            }
        }
    }

    public void searchByGenre(String genre) {
        if (!genreMap.containsKey(genre)) {
            System.out.println(" No books found in genre: " + genre);
            return;
        }

        System.out.println("\n Books in Genre: " + genre);
        for (Book b : genreMap.get(genre)) {
            System.out.println("   " + b);
        }
    }

    public void searchByAuthor(String author) {
        boolean found = false;

        System.out.println("\n Books by Author: " + author);
        for (LinkedList<Book> list : genreMap.values()) {
            for (Book b : list) {
                if (b.getAuthor().equalsIgnoreCase(author)) {
                    System.out.println("   " + b);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println(" No books found for author: " + author);
        }
    }
}

public class BookShelfManager {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LibraryCatalog catalog = new LibraryCatalog();

        while (true) {
            System.out.println("\n==== BookShelf Library Menu ===");
            System.out.println("1. Add Book (Return Book)");
            System.out.println("2. Borrow Book");
            System.out.println("3. Print Catalog");
            System.out.println("4. Search Books by Genre");
            System.out.println("5. Search Books by Author");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    String id = sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    System.out.print("Enter Genre: ");
                    String genre = sc.nextLine();

                    catalog.addBook(new Book(id, title, author, genre));
                    break;

                case 2:
                    System.out.print("Enter Book ID to Borrow: ");
                    String borrowId = sc.nextLine();
                    catalog.borrowBook(borrowId);
                    break;

                case 3:
                    catalog.printCatalog();
                    break;

                case 4:
                    System.out.print("Enter Genre to Search: ");
                    String g = sc.nextLine();
                    catalog.searchByGenre(g);
                    break;

                case 5:
                    System.out.print("Enter Author to Search: ");
                    String a = sc.nextLine();
                    catalog.searchByAuthor(a);
                    break;

                case 6:
                    System.out.println(" Exiting BookShelf Manager. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println(" Invalid choice! Try again.");
            }
        }
    }
}
