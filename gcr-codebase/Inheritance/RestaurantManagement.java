// Superclass: General identity
class Person {
    String name;
    int id;

    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void displayIdentity() {
        System.out.println("ID: " + id + " | Name: " + name);
    }
}

// Interface: Defining a contract for behavior
interface Worker {
    void performDuties(); // Abstract method
}

// Subclass 1: Inheritance + Interface implementation
class Chef extends Person implements Worker {
    String specialty;

    Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        System.out.println("Chef " + name + " is preparing " + specialty + " in the kitchen.");
    }
}

// Subclass 2: Inheritance + Interface implementation
class Waiter extends Person implements Worker {
    int assignedTables;

    Waiter(String name, int id, int assignedTables) {
        super(name, id);
        this.assignedTables = assignedTables;
    }

    @Override
    public void performDuties() {
        System.out.println("Waiter " + name + " is serving " + assignedTables + " tables.");
    }
}

public class RestaurantManagement {
    public static void main(String[] args) {
        Chef headChef = new Chef("Marco", 501, "Italian Cuisine");
        Waiter leadWaiter = new Waiter("Sarah", 502, 5);

        System.out.println("--- Restaurant Staff Roles ---");
        
        // Using identity (from Person)
        headChef.displayIdentity();
        // Using behavior (from Worker)
        headChef.performDuties();
        
        System.out.println();

        leadWaiter.displayIdentity();
        leadWaiter.performDuties();
    }
}
