// package collections_practice.regex;

import java.util.Scanner;

public class ReplaceMultipleSpacesWithASingleSpace {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter text: ");
		String input = sc.nextLine();
		
		String result = input.replaceAll("\\s+", " ");
		System.out.print("After Replacing: ");
		System.out.println(result);
	}

}
