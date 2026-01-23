// package collections_practice.collections;

import java.util.*;

public class GenerateBinaryNumbersUsingAQueue {
	
	public static List<String> generateBinary(int n) {
        List<String> result = new ArrayList<>();
        Queue<String> q = new LinkedList<>();

        q.add("1");

        for (int i = 0; i < n; i++) {
            String curr = q.remove();
            result.add(curr);

            q.add(curr + "0");
            q.add(curr + "1");
        }

        return result;
    }

	public static void main(String[] args) {
		int n = 5;
        System.out.println(generateBinary(n));
	}

}
