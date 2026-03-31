public class Book {
    static String libraryName = "Genius Library";

    final String isbn;
    String title;
    String author;

    public Book(String title, String author, String isbn){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    static void displayLibraryName(){
        System.out.println("Library Name: " + libraryName);
    }

    public void displayDetails(){
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
    }

    public static void main(String[] args){
        Book.displayLibraryName();

        Book book1 = new Book("Playing it my way", "Sachin Tendulkar", "978-0349124012");

        if(book1 instanceof Book){
            book1.displayDetails();
        }
    }

}
