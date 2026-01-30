// package collections_practice.regex;

import java.util.Scanner;
import java.util.regex.*;

public class CensorBadWordsInASentence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter text: ");
		String input = sc.nextLine();
		
		String[] badWords = {"damn", "stupid"};
		
		String regex = "\\b(" + String.join("|", badWords) + ")\\b";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);

        String result = matcher.replaceAll("****");

        System.out.println("Censored Text:");
        System.out.println(result);
        
        sc.close();
	}

}
