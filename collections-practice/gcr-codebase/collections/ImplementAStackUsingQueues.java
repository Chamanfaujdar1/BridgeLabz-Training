// package collections_practice.collections;

import java.util.*;

class StackUsingQueues{
	Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    void push(int x) {
        q2.add(x);
        while (!q1.isEmpty()) q2.add(q1.remove());
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    int pop() {
        return q1.remove();
    }

    int top() {
        return q1.peek();
    }
    
    boolean isEmpty() {
        return q1.isEmpty();
    }
}

public class ImplementAStackUsingQueues {

	public static void main(String[] args) {
		StackUsingQueues st = new StackUsingQueues();
        st.push(1);
        st.push(2);
        st.push(3);

        System.out.println(st.pop());
	}

}
