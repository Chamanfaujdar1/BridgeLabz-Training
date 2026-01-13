import java.util.*;

class Book {
    String title;

    Book(String title) {
        this.title = title;
    }
}

public class SmartShelf {

    static List<Book> shelf = new ArrayList<>();

    static void insertBook(Book newBook) {

        shelf.add(newBook);
        int i = shelf.size() - 1;

        while (i > 0 &&
                shelf.get(i - 1).title.compareToIgnoreCase(newBook.title) > 0) {

            shelf.set(i, shelf.get(i - 1));
            i--;
        }
        shelf.set(i, newBook);
    }

    static void displayShelf() {
        System.out.println("\n📚 SmartShelf (Sorted by Title)");
        for (Book b : shelf) {
            System.out.println(b.title);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Book");
            System.out.println("2. View Shelf");
            System.out.println("3. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    insertBook(new Book(title));
                    System.out.println("Book added and shelf sorted!");
                }
                case 2 -> displayShelf();
                case 3 -> System.exit(0);
            }
        }
    }
}
