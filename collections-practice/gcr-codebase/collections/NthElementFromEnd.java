// package collections_practice.collections;

import java.util.*;

public class NthElementFromEnd {
	public static <T> T nthFromEnd(LinkedList<T> list, int n) {
        if (n <= 0 || n > list.size()) return null;

        Iterator<T> fast = list.iterator();
        Iterator<T> slow = list.iterator();

        for (int i = 0; i < n; i++) {
            if (!fast.hasNext()) return null;
            fast.next();
        }

        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }

        return slow.next();
    }

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        int n = 2;
        System.out.println(nthFromEnd(list, n));
	}

}
