// package collections_practice.regex;

import java.util.*;
import java.util.regex.*;
import java.util.regex.Pattern;

public class UsernameValidation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the String: ");
		String input = sc.nextLine();
		
		String regex = "^[a-zA-Z][a-zA-Z0-9_]{2,}$";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		
		if(matcher.matches()) {
			System.out.println("valid username" );
		}
		else {
			System.out.println("Invalid username" );
		}
		
		sc.close();
	}

}
