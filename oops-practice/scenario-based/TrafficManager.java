import java.util.*;

class VehicleNode {
    String number;
    VehicleNode next;

    VehicleNode(String number) {
        this.number = number;
        this.next = null;
    }
}

class VehicleQueue {
    String[] queue;
    int front = 0, rear = -1, size = 0;

    public VehicleQueue(int capacity) {
        queue = new String[capacity];
    }

    boolean isFull() {
        return size == queue.length;
    }

    boolean isEmpty() {
        return size == 0;
    }

    void enqueue(String car) {
        if (isFull()) {
            System.out.println("Queue Overflow! Cannot add " + car);
            return;
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = car;
        size++;
        System.out.println(car + " added to waiting queue");
    }

    String dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow! No vehicles waiting");
            return null;
        }
        String car = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return car;
    }
}

class Roundabout {
    private VehicleNode head = null;

    void addCar(String car) {
        VehicleNode newNode = new VehicleNode(car);

        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            VehicleNode temp = head;
            while (temp.next != head)
                temp = temp.next;

            temp.next = newNode;
            newNode.next = head;
        }
        System.out.println(car + " entered roundabout");
    }

    void removeCar(String car) {
        if (head == null) {
            System.out.println("Roundabout empty");
            return;
        }

        VehicleNode curr = head, prev = null;

        do {
            if (curr.number.equals(car)) {

                if (curr == head && curr.next == head) {
                    head = null;
                } else {
                    if (curr == head) {
                        VehicleNode temp = head;
                        while (temp.next != head)
                            temp = temp.next;
                        head = curr.next;
                        temp.next = head;
                    } else {
                        prev.next = curr.next;
                    }
                }
                System.out.println(car + " exited roundabout");
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);

        System.out.println("Car not found in roundabout");
    }

    void printState() {
        if (head == null) {
            System.out.println("Roundabout is empty");
            return;
        }

        VehicleNode temp = head;
        System.out.print("Roundabout: ");
        do {
            System.out.print(temp.number + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(Back to Start)");
    }
}

public class TrafficManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Roundabout roundabout = new Roundabout();
        VehicleQueue queue = new VehicleQueue(3);

        while (true) {
            System.out.println("\n--- Traffic Manager ---");
            System.out.println("1. Add Car to Queue");
            System.out.println("2. Move Car from Queue to Roundabout");
            System.out.println("3. Remove Car from Roundabout");
            System.out.println("4. Show Roundabout");
            System.out.println("5. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Car Number: ");
                    queue.enqueue(sc.next());
                }
                case 2 -> {
                    String car = queue.dequeue();
                    if (car != null)
                        roundabout.addCar(car);
                }
                case 3 -> {
                    System.out.print("Car Number: ");
                    roundabout.removeCar(sc.next());
                }
                case 4 -> roundabout.printState();
                case 5 -> System.exit(0);
            }
        }
    }
}
