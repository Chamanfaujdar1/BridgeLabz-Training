// package collections_practice.collections;

import java.util.*;

public class MergeTwoMaps {
	
	public static Map<String, Integer> mergeMaps(Map<String, Integer> m1, Map<String, Integer> m2) {
        Map<String, Integer> result = new HashMap<>(m1);

        for (Map.Entry<String, Integer> e : m2.entrySet()) {
            String key = e.getKey();
            int val = e.getValue();
            result.put(key, result.getOrDefault(key, 0) + val);
        }

        return result;
    }

	public static void main(String[] args) {
		Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        System.out.println(mergeMaps(map1, map2));
	}

}
