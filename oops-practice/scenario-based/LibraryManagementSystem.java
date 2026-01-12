import java.util.*;

class BookNotAvailableException extends Exception{
    public BookNotAvailableException(String message){
        super(message);
    }
}

interface FineCalculator{
    double CalculateFine(int daysLate);
}

class User{
    private int userId;
    private String name;
    
    public User(int userId, String name){
        this.userId = userId;
        this.name = name;
    } 
}

abstract class Member extends User implements FineCalculator {
    protected int issuedBooks = 0;

    public Member(String name, String userId) {
        super(name, userId);
    }

    abstract String getType();
}

class Student extends Member {

    public Student(String name, String userId) {
        super(name, userId);
    }

    public double calculateFine(int daysLate) {
        return daysLate * 2;   // ₹2 per day
    }

    public String getType() {
        return "Student";
    }
}

class Staff extends Member {

    public Staff(String name, String userId) {
        super(name, userId);
    }

    public double calculateFine(int daysLate) {
        return daysLate * 1;   // ₹1 per day
    }

    public String getType() {
        return "Staff";
    }
}

class Book {
    String bookId;
    String title;
    int copies;

    public Book(String bookId, String title, int copies) {
        this.bookId = bookId;
        this.title = title;
        this.copies = copies;
    }
}

class Transaction {
    Book book;
    Member member;
    int daysLate;

    public Transaction(Book book, Member member, int daysLate) {
        this.book = book;
        this.member = member;
        this.daysLate = daysLate;
    }
}

public class LibraryManagementSystem {
    static List<Book> books = new ArrayList<>();
    static List<Member> members = new ArrayList<>();
    static List<Transaction> transactions = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        while (true) {
            System.out.println("\n--- Library System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Register Member");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. View Books");
            System.out.println("6. Exit");

            int choice = sc.nextInt();
            try {
                switch (choice) {
                    case 1 -> addBook();
                    case 2 -> registerMember();
                    case 3 -> issueBook();
                    case 4 -> returnBook();
                    case 5 -> viewBooks();
                    case 6 -> System.exit(0);
                }
            } catch (BookNotAvailableException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
    }

    static void addBook() {
        System.out.print("Book ID: ");
        String id = sc.next();
        System.out.print("Title: ");
        String title = sc.next();
        System.out.print("Copies: ");
        int copies = sc.nextInt();

        books.add(new Book(id, title, copies));
        System.out.println("Book Added");
    }

    static void registerMember() {
        System.out.print("1.Student  2.Staff : ");
        int type = sc.nextInt();
        System.out.print("Name: ");
        String name = sc.next();
        System.out.print("ID: ");
        String id = sc.next();

        if (type == 1)
            members.add(new Student(name, id));
        else
            members.add(new Staff(name, id));

        System.out.println("Member Registered");
    }

    static void issueBook() throws BookNotAvailableException {
        System.out.print("Book ID: ");
        String bookId = sc.next();
        System.out.print("Member ID: ");
        String memId = sc.next();

        Book book = findBook(bookId);
        Member member = findMember(memId);

        if (book.copies == 0)
            throw new BookNotAvailableException("No copies available!");

        book.copies--;
        transactions.add(new Transaction(book, member, 0));
        System.out.println("Book Issued");
    }

    static void returnBook() {
        System.out.print("Member ID: ");
        String id = sc.next();
        System.out.print("Days Late: ");
        int days = sc.nextInt();

        for (Transaction t : transactions) {
            if (t.member.userId.equals(id)) {
                t.book.copies++;
                double fine = t.member.calculateFine(days);
                System.out.println("Returned. Fine = ₹" + fine);
                return;
            }
        }
        System.out.println("Transaction not found");
    }

    static void viewBooks() {
        for (Book b : books) {
            System.out.println(b.bookId + " " + b.title + " Copies: " + b.copies);
        }
    }

    static Book findBook(String id) {
        for (Book b : books)
            if (b.bookId.equals(id))
                return b;
        return null;
    }

    static Member findMember(String id) {
        for (Member m : members)
            if (m.userId.equals(id))
                return m;
        return null;
    }
}