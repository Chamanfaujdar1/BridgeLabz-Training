// package collections_practice.collections;

import java.util.*;

class CircularBuffer{
	int[] arr;
    int size;
    int front;
    int count;

    CircularBuffer(int size) {
        this.size = size;
        arr = new int[size];
        front = 0;
        count = 0;
    }
    
    void insert(int x) {
        if (count < size) {
            int idx = (front + count) % size;
            arr[idx] = x;
            count++;
        } else {
            arr[front] = x;
            front = (front + 1) % size;
        }
    }
    
    List<Integer> getBuffer() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(arr[(front + i) % size]);
        }
        return result;
    }
}

public class CircularBufferSimulation {

	public static void main(String[] args) {
		CircularBuffer buffer = new CircularBuffer(3);
        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        buffer.insert(4);

        System.out.println(buffer.getBuffer());
	}

}
