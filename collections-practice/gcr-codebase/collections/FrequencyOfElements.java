// package collections_practice.collections;

import java.util.*;

public class FrequencyOfElements {

	public static void main(String[] args) {
		List<String> input = List.of("apple", "banana", "apple", "orange");

        Map<String, Integer> freqMap = new HashMap<>();
        
        for(String item : input) {
        	freqMap.put(item, freqMap.getOrDefault(item, 0)+1);
        }
        
        System.out.println(freqMap);
        
	}
}
