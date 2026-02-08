public class LibraryCatalog {
    private static LibraryCatalog instance;
    private List<Book> books = new ArrayList<>();

    private LibraryCatalog(){}

    public static synchronized LibraryCatalog getInstance(){
        if(instance == null){
            instance = new LibraryCatalog();
        }
        return instance;
    }

    public void addBook(Book book){
        books.add(book);
        notofyObservers(book.getTitle());
    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    private void notifyObservers(String bookName){
        for(Observer o : observers){
            o.update("New book available: " + bookName);
        }
    }
}
