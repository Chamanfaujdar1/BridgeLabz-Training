// package collections_practice.scenario_based;

import java.util.*;

class TableAlreadyReservedException extends Exception{
	public TableAlreadyReservedException(String message) {
		super(message);
	}
}

class Table{
	private int tableNumber;
	private int capacity;
	
	public Table(int tableNumber, int capacity) {
		this.tableNumber = tableNumber;
		this.capacity = capacity;
	}
	
	public int getTableNumber() {
		return tableNumber;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	@Override
	public String toString() {
		return "Table: " + tableNumber + " Seating capacity " + capacity;
	}
}

class Reservation{
	private int tableNumber;
	private String customerName;
	private String timeSlot;
	
	public Reservation(int tableNumber, String customerName, String timeSlot) {
		this.tableNumber = tableNumber;
		this.customerName = customerName;
		this.timeSlot = timeSlot;
	}
	
	public int getTableNumber() {
		return tableNumber;
	}
	
	public String getTimeSlot() {
		return timeSlot;
	}
	
	@Override
	public String toString() {
		return "Table " + tableNumber + " Reserved By " + customerName + " At time " + timeSlot;
	}
}

class Restaurant{
	private Map<Integer, Table> tables = new HashMap<>();
	private List<Reservation> reservations = new ArrayList<>();
	
	public void addTable(Table table) {
		tables.put(table.getTableNumber(), table);
	}
	
	public void reserveTable(int tableNumber, String customerName, String timeSlot) throws TableAlreadyReservedException {
		for(Reservation r : reservations) {
			if (r.getTableNumber() == tableNumber &&
	                r.getTimeSlot().equalsIgnoreCase(timeSlot)) {
	                throw new TableAlreadyReservedException(
	                        "Table " + tableNumber + " is already reserved for " + timeSlot);
	            }
		}
		
		reservations.add(new Reservation(tableNumber, customerName, timeSlot));
		System.out.println("Reservation successfull");
	}
	
	public void cancelReservation(int tableNumber, String timeSlot) {
		Iterator<Reservation> iterator = reservations.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            Reservation r = iterator.next();
            if (r.getTableNumber() == tableNumber &&
                r.getTimeSlot().equalsIgnoreCase(timeSlot)) {
                iterator.remove();
                found = true;
                System.out.println("Reservation cancelled successfully!");
                break;
            }
        }
        
        if (!found) {
            System.out.println("No reservation found to cancel.");
        }
	}
	
	public void showAvailableTables(String timeSlot) {
        System.out.println("Available tables for " + timeSlot + ":");

        for (Table table : tables.values()) {
            boolean reserved = false;
            for (Reservation r : reservations) {
                if (r.getTableNumber() == table.getTableNumber() &&
                    r.getTimeSlot().equalsIgnoreCase(timeSlot)) {
                    reserved = true;
                    break;
                }
            }
            if (!reserved) {
                System.out.println(table);
            }
        }
    }
}

public class RestaurantTableReservationSystem{
	public static void main(String[] args) {
		Restaurant restaurant = new Restaurant();

        restaurant.addTable(new Table(1, 4));
        restaurant.addTable(new Table(2, 6));
        restaurant.addTable(new Table(3, 2));

        try {
            restaurant.reserveTable(1, "Rahul", "7PM-8PM");
            restaurant.reserveTable(2, "Aditi", "7PM-8PM");

            restaurant.reserveTable(1, "Aman", "7PM-8PM");

        } catch (TableAlreadyReservedException e) {
            System.out.println(e.getMessage());
        }
        
        restaurant.showAvailableTables("7PM-8PM");

        restaurant.cancelReservation(1, "7PM-8PM");

        restaurant.showAvailableTables("7PM-8PM");
	}
}