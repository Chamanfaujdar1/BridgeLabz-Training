// package collections_practice.regex;

import java.util.Scanner;
import java.util.regex.*;

public class CapitalizedWordsExtraction {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the sentence: ");
		String sentence = sc.nextLine();
		
		String regex = "\\b[A-Z][a-z]*\\b";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(sentence);
		
		while(matcher.find()) {
			System.out.println(matcher.group());
		}
	}

}
