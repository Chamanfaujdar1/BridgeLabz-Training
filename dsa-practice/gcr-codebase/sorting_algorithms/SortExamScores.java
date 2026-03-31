package sorting_algorithms;

import java.util.Arrays;

public class SortExamScores {
	public static void selectionSort(int[] scores) {
		int n = scores.length;
		
		for(int i=0; i<n-1; i++) {
			int minIdx = i;
			for(int j=i+1; j<n; j++) {
				if(scores[j] < scores[minIdx]) {
					minIdx = j;
				}
			}
			
			int temp = scores[minIdx];
			scores[minIdx] = scores[i];
			scores[i] = temp;
		}
	}

	public static void main(String[] args) {
		int[] scores = {88, 90, 65, 100, 55};
		selectionSort(scores);
		System.out.println(Arrays.toString(scores));
	}

}
