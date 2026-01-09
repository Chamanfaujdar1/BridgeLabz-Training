public class RoundRobin {

    static class Node {
        int pid, bt;
        Node next;

        Node(int p, int b) {
            pid = p;
            bt = b;
        }
    }

    Node head, tail;

    void add(int p, int b) {
        Node nn = new Node(p, b);
        if (head == null) {
            head = tail = nn;
            nn.next = head;
            return;
        }
        tail.next = nn;
        nn.next = head;
        tail = nn;
    }

    void execute(int tq) {
        Node cur = head;
        while (head != null) {
            if (cur.bt > tq) {
                cur.bt -= tq;
            } else {
                System.out.println("Process " + cur.pid + " completed");
                remove(cur.pid);
            }
            cur = cur.next;
        }
    }

    void remove(int pid) {
        if (head == null)
            return;
        Node cur = head, prev = tail;
        do {
            if (cur.pid == pid) {
                if (cur == head)
                    head = head.next;
                prev.next = cur.next;
                if (cur == tail)
                    tail = prev;
                if (head == tail)
                    head = tail = null;
                return;
            }
            prev = cur;
            cur = cur.next;
        } while (cur != head);
    }
}