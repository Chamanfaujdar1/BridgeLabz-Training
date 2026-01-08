public class Inventory {

    static class Node {
        int id, qty;
        String name;
        double price;
        Node next;

        Node(int i, String n, int q, double p) {
            id = i;
            name = n;
            qty = q;
            price = p;
        }
    }

    Node head;

    void add(int i, String n, int q, double p) {
        Node nn = new Node(i, n, q, p);
        nn.next = head;
        head = nn;
    }

    void updateQty(int id, int q) {
        Node t = head;
        while (t != null) {
            if (t.id == id) {
                t.qty = q;
                return;
            }
            t = t.next;
        }
    }

    double totalValue() {
        double sum = 0;
        for (Node t = head; t != null; t = t.next)
            sum += t.qty * t.price;
        return sum;
    }
}