// package collections_practice.collections;

import java.util.*;

public class RotateElements {
	public static void rotateList(List<Integer> list, int k) {
		k = k%list.size();
		List<Integer> temporaryList = new ArrayList<>();
		
		for(int i=k; i<list.size(); i++) {
			temporaryList.add(list.get(i));
		}
		
		for(int i=0; i<k; i++) {
			temporaryList.add(list.get(i));
		}
		
		list.clear();
		list.addAll(temporaryList);
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(List.of(10,20,30,40,50));
		rotateList(list, 2);
		System.out.println(list);
	}

}
