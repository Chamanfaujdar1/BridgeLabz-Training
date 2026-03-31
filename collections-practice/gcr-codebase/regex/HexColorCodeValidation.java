// package collections_practice.regex;

import java.util.Scanner;
import java.util.regex.*;
import java.util.regex.Pattern;

public class HexColorCodeValidation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Color Code: ");
		String input = sc.nextLine();
		
		String regex = "^[#][0-9A-Fa-f]{6}$";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		
		if(matcher.matches()) {
			System.out.println(input + " is valid");
		}
		else {
			System.out.println(input + " is not valid");
		}
	}

}
