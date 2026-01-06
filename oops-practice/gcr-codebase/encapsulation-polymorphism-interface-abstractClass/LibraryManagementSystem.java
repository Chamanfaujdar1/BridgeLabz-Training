import java.util.*;

abstract class LibraryItem{
    private String itemId;
    private String title;
    private String author;

    private String borrowerName;
    private boolean isAvailable = true;

    public LibraryItem(String itemId, String title, String author){
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public String getItemId(){
        return itemId;
    }

    public String getTitle(){
        return title;
    }
    
    protected void setBorrower(String name){
        this.borrowerName = name;
        this.isAvailable = false;
    }

    protected void releaseItem(){
        this.borrowerName = null;
        this.isAvailable = true;
    }

    protected boolean isAvailable(){
        return isAvailable;
    }

    public abstract int getLoanDuration();

    public void getItemDetails(){
        System.out.print("Item Id: " + itemId);
        System.out.print("Title: " + title);
        System.out.print("Author: " + author);
        System.out.print("Available: " + isAvailable);
    }
}

class Book extends LibraryItem implements Reservable{
    public Book(String id, String title, String author){
        super(id, title, author);
    }

    public int getLoanDuration(){
        return 28;
    }

    public void reserveItem(String borrowerName){
        if(isAvailable()){
            setBorrower(borrowerName);
            System.out.println("Book reserved by " + borrowerName);
        }
        else{
            System.out.println("Book is already reserved");
        }
    }

    public boolean checkAvailability(){
        return isAvailable();
    }
}

class Magazine extends LibraryItem implements Reservable{
    public Magazine(String id, String title, String author){
        super(id, title, author);
    }

    public int getLoanDuration(){
        return 15;
    }

    public void reserveItem(String borrowerName){
        if(isAvailable()){
            setBorrower(borrowerName);
            System.out.println("Magazine reserved by " +borrowerName);
        }
        else{
            System.out.println("Magazine is already reserved");
        }
    }

    public boolean checkAvailability(){
        return isAvailable();
    }
}

class DVD extends LibraryItem implements Reservable{
    public DVD(String id, String title, String author){
        super(id, title, author);
    }

    public int getLoanDuration(){
        return 8;
    }

    public void reserveItem(String borrowerName){
        if(isAvailable()){
            setBorrower(borrowerName);
            System.out.println("DVD reserved by " + borrowerName);
        }
        else{
            System.out.println("DVD is already reserved");
        }
    }

    public boolean checkAvailability(){
        return isAvailable();
    }
}

interface Reservable{
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

public class LibraryManagementSystem {
    public static void main(String[] args){
        List<LibraryItem> items = new ArrayList<>();

        items.add(new Book("B101", "Effective Java", "Joshua Bloch"));
        items.add(new Magazine("M201", "National Geographic", "NG Team"));
        items.add(new DVD("D301", "Inception", "Christopher Nolan"));

        for (LibraryItem item : items) {
            System.out.println("\n-- Library Item --");
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            if (item instanceof Reservable) {
                Reservable reservable = (Reservable) item;
                reservable.reserveItem("Amit");
                System.out.println("Available After Reservation: " + reservable.checkAvailability());
            }
        }
    }
}
