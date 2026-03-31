// package collections_practice.collections;

import java.util.*;

public class WordFrequencyCounter {
	
	public static Map<String, Integer> countWords(String text) {
        Map<String, Integer> map = new HashMap<>();
        String[] words = text.toLowerCase().replaceAll("[^a-z0-9 ]", " ").split("\\s+");

        for (String w : words) {
            if (w.length() == 0) continue;
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        return map;
    }

	public static void main(String[] args) {
		String text = "Hello world, hello Java!";
        System.out.println(countWords(text));
	}

}
