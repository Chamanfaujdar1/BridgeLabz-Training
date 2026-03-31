class Book3 {
    public String isbn;
    protected String title;
    private String author;

    public Book3(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

class EBook extends Book3 {
    double fileSizeMB;

    public EBook(String isbn, String title, String author, double fileSizeMB) {
        super(isbn, title, author);
        this.fileSizeMB = fileSizeMB;
    }

    public void displayEBookDetails() {
        System.out.println("ISBN: " + isbn); 
        System.out.println("Title: " + title); 
        System.out.println("Author: " + getAuthor()); 
        System.out.println("File Size: " + fileSizeMB + "MB");
        System.out.println("-------------------------");
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        EBook ebook = new EBook("978-3-16", "Digital Fortress", "Dan Brown", 5.5);
        
        ebook.displayEBookDetails();
        ebook.setAuthor("Robert Dan Brown");
        System.out.println("Updated Author Details:");
        ebook.displayEBookDetails();
    }
}