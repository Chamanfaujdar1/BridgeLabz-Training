// package collections_practice.regex;

import java.util.Scanner;
import java.util.regex.*;

public class WebPageLinkExtraction {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Web Page Link: ");
		String link = sc.nextLine();
		
		String regex = "(https?://)[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(/.*)?";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(link);
		
		while(matcher.find()) {
			System.out.println(matcher.group());
		}
	}

}
