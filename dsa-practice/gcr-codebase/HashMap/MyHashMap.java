import java.util.LinkedList;

public class MyHashMap {

    static class Node {
        int key, val;

        Node(int k, int v) {
            key = k;
            val = v;
        }
    }

    LinkedList<Node>[] arr = new LinkedList[5];

    void put(int k, int v) {
        int idx = k % 5;
        if (arr[idx] == null)
            arr[idx] = new LinkedList<>();
        for (Node n : arr[idx]) {
            if (n.key == k) {
                n.val = v;
                return;
            }
        }
        arr[idx].add(new Node(k, v));
    }

    int get(int k) {
        int idx = k % 5;
        if (arr[idx] != null) {
            for (Node n : arr[idx])
                if (n.key == k)
                    return n.val;
        }
        return -1;
    }

    public static void main(String[] args) {
        MyHashMap m = new MyHashMap();
        m.put(1, 10);
        m.put(6, 20);
        System.out.println(m.get(6));
    }
}