// package core_java_programs.scenario_based.FlipKeyLogicalProblem;

import java.util.*;

public class FlipKey {
	public static String CleanseAndInvert(String input) {
		if(input == null || input.length() < 6) {
			return "";
		}
		
		for(char ch : input.toCharArray()) {
			if(!Character.isLetter(ch)) {
				return "";
			}
		}
		
		input = input.toLowerCase();
		
		StringBuilder sb = new StringBuilder();
		for(char ch : input.toCharArray()) {
			if(ch % 2 != 0) {
				sb.append(ch);
			}
		}
		
		sb.reverse();
		
		for(int i=0; i<sb.length(); i++) {
			if(i%2 == 0) {
				sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
			}
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the word: ");
		String input = sc.nextLine();
		
		String result = CleanseAndInvert(input);
		
		if(result.isEmpty()) {
			System.out.println("Invalid Input");
		}
		else {
			System.out.println("The generated key is - " + result);
		}
	}

}
