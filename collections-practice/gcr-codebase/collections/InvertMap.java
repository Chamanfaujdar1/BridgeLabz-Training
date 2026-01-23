// package collections_practice.collections;

import java.util.*;

public class InvertMap {
	
	public static <K, V> Map<V, List<K>> invertMap(Map<K, V> map) {
        Map<V, List<K>> result = new HashMap<>();

        for (Map.Entry<K, V> entry : map.entrySet()) {
            V value = entry.getValue();
            K key = entry.getKey();

            result.putIfAbsent(value, new ArrayList<>());
            result.get(value).add(key);
        }

        return result;
    }

	public static void main(String[] args) {
		Map<String, Integer> input = new HashMap<>();
        input.put("A", 1);
        input.put("B", 2);
        input.put("C", 1);

        System.out.println(invertMap(input));
	}

}
