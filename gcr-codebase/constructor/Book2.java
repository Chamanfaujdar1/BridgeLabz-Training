public class Book2 {
    String title;
    String author;
    double price;
    boolean isAvailable;

    public Book2(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = true; 
    }

    public void borrowBook() {
        System.out.println("Attempting to borrow: " + title);
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Success! You have borrowed '" + title + "'.");
        } else {
            System.out.println("Sorry, '" + title + "' is already borrowed.");
        }
        System.out.println("-----------------------------------");
    }

    public void displayStatus() {
        String status = isAvailable ? "Available" : "Borrowed";
        System.out.println("Book: " + title + " | Author: " + author + " | Status: " + status);
    }

    public static void main(String[] args) {
        Book2 myBook = new Book2("The Lost Ring", "John Milton", 400.0);

        myBook.displayStatus();
        myBook.borrowBook();
        myBook.displayStatus();
    }
}