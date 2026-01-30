// package collections_practice.regex;

import java.util.Scanner;
import java.util.regex.*;

public class DateExtraction {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter date: ");
		String date = sc.nextLine();
		String regex = "^\\d{2}/\\d{2}/\\d{4}$";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(date);
		
		while(matcher.find()) {
			System.out.print(matcher.group() + ", ");
		}
	}

}
