// package collections_practice.collections;

import java.util.*;

public class ReverseList {
	public static <T> void reverseList(List<T> list) {
		int left = 0;
		int right = list.size()-1;
		
		while(left < right) {
			T temp = list.get(left);
			list.set(left, list.get(right));
			list.set(right, temp);
			
			left++;
			right--;
		}
	}

	public static void main(String[] args) {
		List<Integer> arrayList = new ArrayList<>(Arrays.asList(5,8,4,9,1,7));
		List<Integer> linkedList = new LinkedList<>(arrayList);
		System.out.println("Original List: " + arrayList);
		reverseList(arrayList);
		System.out.println("Reversed List: " + arrayList);
		reverseList(linkedList);
		System.out.print("Reversed linked list: " + linkedList);
	}

}
