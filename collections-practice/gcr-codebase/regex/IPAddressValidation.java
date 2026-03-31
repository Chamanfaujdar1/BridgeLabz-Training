// package collections_practice.regex;

import java.util.Scanner;
import java.util.regex.*;

public class IPAddressValidation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter IP Address: ");
		String IPAddress = sc.nextLine();
		
		String regex = "^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}"
				+ "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(IPAddress);
		
		if(matcher.matches()) {
			System.out.println(IPAddress +" is a valid IP Address");
		}
		else {
			System.out.println(IPAddress +" is not a valid IP Address");
		}
	}

}
