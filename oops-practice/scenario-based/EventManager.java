import java.util.*;

class Ticket {
    int ticketId;
    double price;

    Ticket(int id, double price) {
        this.ticketId = id;
        this.price = price;
    }
}

public class EventManager {

    static void quickSort(Ticket[] tickets, int low, int high) {
        if (low < high) {
            int p = partition(tickets, low, high);

            quickSort(tickets, low, p - 1);
            quickSort(tickets, p + 1, high);
        }
    }

    static int partition(Ticket[] tickets, int low, int high) {
        double pivot = tickets[high].price;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (tickets[j].price < pivot) {
                i++;
                swap(tickets, i, j);
            }
        }
        swap(tickets, i + 1, high);
        return i + 1;
    }

    static void swap(Ticket[] t, int i, int j) {
        Ticket temp = t[i];
        t[i] = t[j];
        t[j] = temp;
    }

    public static void main(String[] args) {

        Ticket[] tickets = {
                new Ticket(101, 2500),
                new Ticket(102, 1500),
                new Ticket(103, 4000),
                new Ticket(104, 1800),
                new Ticket(105, 1200),
                new Ticket(106, 3000)
        };

        System.out.println("Before Sorting:");
        for (Ticket t : tickets)
            System.out.println(t.ticketId + " ₹" + t.price);

        quickSort(tickets, 0, tickets.length - 1);

        System.out.println("\nAfter Quick Sort (By Price):");
        for (Ticket t : tickets)
            System.out.println(t.ticketId + " ₹" + t.price);

        System.out.println("\nTop 3 Cheapest Tickets:");
        for (int i = 0; i < 3; i++)
            System.out.println(tickets[i].ticketId + " ₹" + tickets[i].price);
    }
}
