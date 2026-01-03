// Superclass
class Book {
    String title;
    int publicationYear;

    Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Published In: " + publicationYear);
    }
}

class Author extends Book {
    String name;
    String bio;
    Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear); 
        this.name = name;
        this.bio = bio;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Author Name: " + name);
        System.out.println("Author Bio: " + bio);
    }
}

public class LibraryManagement {
    public static void main(String[] args){
        Author myBook = new Author(
            "The Great Gatsby", 
            1925,
            "F. Scott Fitzgerald", 
            "An American novelist known for his depictions of the Jazz Age."
        );

        System.out.println("--- Library Record ---");
        myBook.displayInfo();

    }
}
