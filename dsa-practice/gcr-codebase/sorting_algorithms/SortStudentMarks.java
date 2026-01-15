package sorting_algorithms;

import java.util.Arrays;

public class SortStudentMarks {
	public static void sort(int[] marks) {
		// Bubble Sort
		int n = marks.length;
		for(int i=0; i<n; i++) {
			boolean swapped = false;
			for(int j=0; j<n-i-1; j++) {
				if(marks[j] > marks[j+1]) {
					int temp = marks[j];
					marks[j] = marks[j+1];
					marks[j+1] = temp;
					swapped = true;
				}
			}
			if(!swapped) break;
		}
	}
	public static void main(String[] args) {
		int[] marks = {8, 10, 5, 3, 9, 7};
		sort(marks);
		System.out.println(Arrays.toString(marks));
	}
}
