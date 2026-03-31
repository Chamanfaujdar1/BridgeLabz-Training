// package collections_practice.collections;

import java.util.*;

public class KeyWithHighestValue {
	
	public static String maxKey(Map<String, Integer> map) {
        String ans = null;
        int max = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                ans = e.getKey();
            }
        }
        return ans;
    }

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);

        System.out.println(maxKey(map));
	}

}
