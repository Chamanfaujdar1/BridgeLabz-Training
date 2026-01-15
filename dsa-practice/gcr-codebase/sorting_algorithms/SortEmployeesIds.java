package sorting_algorithms;

import java.util.Arrays;

public class SortEmployeesIds {
	public static void insertionSort(int[] id) {
		int n = id.length;
		for(int i=1; i<n; i++) {
			int keyElement = id[i];
			int j = i-1;
			
			while(j >= 0 && id[j] > keyElement) {
				id[j+1] = id[j];
				j--;
			}
			id[j+1] = keyElement;
		}
	}
	public static void main(String[] args) {
		int[] id = {108, 110, 101, 109, 105, 104, 102, 106, 103, 107};
		insertionSort(id);
		System.out.println(Arrays.toString(id));
	}
}
