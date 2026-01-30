// package collections_practice.regex;

import java.util.*;
import java.util.regex.*;

public class LicensePlateNumberValidation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the string: ");
		String input = sc.nextLine();
		
		String regex = "^[A-Z]{2}[0-9]{4}$";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		
		if(matcher.matches()) {
			System.out.println(input + " is valid");
		}
		else {
			System.out.println(input + " is invalid");
		}
	}

}
