public class TicketSystem {

    static class Node {
        int id;
        String name, movie, seat;
        Node next;

        Node(int i, String n, String m, String s) {
            id = i;
            name = n;
            movie = m;
            seat = s;
        }
    }

    Node head, tail;

    void book(int i, String n, String m, String s) {
        Node nn = new Node(i, n, m, s);
        if (head == null) {
            head = tail = nn;
            nn.next = head;
            return;
        }
        tail.next = nn;
        nn.next = head;
        tail = nn;
    }

    void display() {
        if (head == null)
            return;
        Node t = head;
        do {
            System.out.println(t.id + " " + t.name + " " + t.movie + " " + t.seat);
            t = t.next;
        } while (t != head);
    }
}