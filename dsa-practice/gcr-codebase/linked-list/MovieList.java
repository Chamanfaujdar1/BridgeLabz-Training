public class MovieList {

    static class Node {
        String title, dir;
        int year;
        double rating;
        Node next, prev;

        Node(String t, String d, int y, double r) {
            title = t;
            dir = d;
            year = y;
            rating = r;
        }
    }

    Node head, tail;

    void addEnd(String t, String d, int y, double r) {
        Node nn = new Node(t, d, y, r);
        if (head == null) {
            head = tail = nn;
            return;
        }
        tail.next = nn;
        nn.prev = tail;
        tail = nn;
    }

    void updateRating(String title, double r) {
        Node t = head;
        while (t != null) {
            if (t.title.equalsIgnoreCase(title)) {
                t.rating = r;
                return;
            }
            t = t.next;
        }
    }

    void displayForward() {
        Node t = head;
        while (t != null) {
            System.out.println(t.title + " " + t.rating);
            t = t.next;
        }
    }

    void displayReverse() {
        Node t = tail;
        while (t != null) {
            System.out.println(t.title + " " + t.rating);
            t = t.prev;
        }
    }

    public static void main(String[] args) {
        MovieList m = new MovieList();
        m.addEnd("Inception", "Nolan", 2010, 9);
        m.addEnd("Avatar", "Cameron", 2009, 8.5);
        m.displayForward();
        m.updateRating("Avatar", 9);
        m.displayReverse();
    }
}