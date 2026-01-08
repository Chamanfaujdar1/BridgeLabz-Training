public class TextEditor {

    static class Node {
        String text;
        Node next, prev;

        Node(String t) {
            text = t;
        }
    }

    Node cur;

    void addState(String t) {
        Node nn = new Node(t);
        if (cur != null) {
            cur.next = nn;
            nn.prev = cur;
        }
        cur = nn;
    }

    void undo() {
        if (cur != null && cur.prev != null)
            cur = cur.prev;
    }

    void redo() {
        if (cur != null && cur.next != null)
            cur = cur.next;
    }

    void show() {
        if (cur != null)
            System.out.println(cur.text);
    }
}