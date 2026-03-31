public class TaskScheduler {

    static class Node {
        int id, priority;
        String name;
        Node next;

        Node(int id, String name, int p) {
            this.id = id;
            this.name = name;
            this.priority = p;
        }
    }

    Node head = null, tail = null;

    void addTask(int id, String name, int p) {
        Node nn = new Node(id, name, p);
        if (head == null) {
            head = tail = nn;
            nn.next = head;
            return;
        }
        tail.next = nn;
        nn.next = head;
        tail = nn;
    }

    void showTasks() {
        if (head == null)
            return;
        Node t = head;
        do {
            System.out.println(t.id + " " + t.name + " " + t.priority);
            t = t.next;
        } while (t != head);
    }

    void nextTask() {
        if (head != null)
            head = head.next;
    }

    public static void main(String[] args) {
        TaskScheduler t = new TaskScheduler();
        t.addTask(1, "Email", 1);
        t.addTask(2, "Code", 2);
        t.showTasks();
        System.out.println("Next Task");
        t.nextTask();
        t.showTasks();
    }
}