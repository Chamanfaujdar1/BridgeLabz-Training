// package collections_practice.collections;

import java.util.*;

public class RemoveDuplicates {
	public static List<Integer> duplicateRemover(List<Integer> list) {
		Set<Integer> seen = new HashSet<>();
		List<Integer> result = new ArrayList<>();
		
		for(int num : list) {
			if(!seen.contains(num)) {
				seen.add(num);
				result.add(num);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		List<Integer> input = Arrays.asList(3,1,2,2,3,4);
		System.out.println(duplicateRemover(input));
	}

}
