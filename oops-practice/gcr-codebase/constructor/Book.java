public class Book {
    String title;
    String author;
    double price;

    Book(){
        this.title = "Unknown Title";
        this.author = "Unknown Author";
        this.price = 0.0;
    }

    Book(String title, String author, double price){
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void displayBookInfo(){
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args){
        Book book1 = new Book();
        Book book2 = new Book("The lost ring", "William shakespeare", 350.0);

        book1.displayBookInfo();
        book2.displayBookInfo();
    }
}
