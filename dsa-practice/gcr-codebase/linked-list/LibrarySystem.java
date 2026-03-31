public class LibrarySystem {

    static class Node {
        String title, author, genre;
        int id;
        boolean available;
        Node next, prev;

        Node(int i, String t, String a, String g) {
            id = i;
            title = t;
            author = a;
            genre = g;
            available = true;
        }
    }

    Node head, tail;

    void addBook(int i, String t, String a, String g) {
        Node nn = new Node(i, t, a, g);
        if (head == null) {
            head = tail = nn;
            return;
        }
        tail.next = nn;
        nn.prev = tail;
        tail = nn;
    }

    void updateStatus(int id, boolean s) {
        Node t = head;
        while (t != null) {
            if (t.id == id) {
                t.available = s;
                return;
            }
            t = t.next;
        }
    }

    int count() {
        int c = 0;
        for (Node t = head; t != null; t = t.next)
            c++;
        return c;
    }
}